package com.normdevstorm.commerce_platform.controller.payment;

import com.normdevstorm.commerce_platform.model.PayPalPaymentResponse;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${application.paypal.success_url}")
    private String SUCCESS_URL;
    @Value("${application.paypal.cancel_url}")
    private String CANCEL_URL;
    private final PayPalService payPalService;

    @Autowired
    public PaymentController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    //todo: pass transactionId into var
    @GetMapping()
    public Object home(){
        return new ModelAndView("paymentPreview");

    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
        public Object createPayment(@RequestParam String method,
                              @RequestParam Double amount,
                              @RequestParam String currency,
                              @RequestParam String description
    ) {

        try {
            Payment payment = payPalService.createPayment(amount, currency, method, "sale", description, CANCEL_URL,
                    SUCCESS_URL);
            for (Links link : payment.getLinks()
            ) {
                if (link.getRel().equals("approval_url")) {
                    //web platform
//                    return new ModelAndView(new RedirectView(link.getHref()));
//                    return response to mobile app
                    return Optional.ofNullable(ResponseEntity.ok(GenericResponse.<PayPalPaymentResponse>builder().success(true).message("Payment creation is processing !!!").data(new PayPalPaymentResponse(link.getHref())).build()));
                }
            }
        } catch (PayPalRESTException e) {
            log.error("Create payment exception::", e);
        }
        return new ModelAndView(new RedirectView("/error", true));
    }

    @GetMapping("/success")
    Object excecuteSuccess(@RequestParam("PayerID") String payerId, @RequestParam("paymentId") String paymentId) throws PayPalRESTException {
        try {
            Payment payment = payPalService.executePayment(payerId, paymentId);
            boolean isSuccess = payment.getState().equals("approved");
            //mobile
            return Optional.of(  isSuccess ? ResponseEntity.ok(GenericResponse.builder().success(true).message("Payment succeeded !!!").data("").build()) : ResponseEntity.notFound());
            //web
//            return new ModelAndView("paymentSuccess");
        } catch (PayPalRESTException e) {
            log.error("Error occurred:: ", e);
        }
        return new ModelAndView(new RedirectView("/error", true));
    }

    @GetMapping("/cancel")
    public Object paymentCancel() {
        //web
//        return new ModelAndView("paymentCancel");
        //mobile app
        return Optional.of(ResponseEntity.ok(GenericResponse.builder().message("Payment canceled !!!").data("").success(false).build()));
    }

    @GetMapping("/error")
    public Object paymentError() {
//        return new ModelAndView("paymentError");
        return Optional.of(ResponseEntity.ok(GenericResponse.builder().success(false).message("Got an error trying to process the payment!!!").data("").build()));
    }
}
