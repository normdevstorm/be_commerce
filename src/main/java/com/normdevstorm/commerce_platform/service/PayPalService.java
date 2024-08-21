package com.normdevstorm.commerce_platform.service;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;

@Service
public class PayPalService {
    private final APIContext apiContext;

    @Autowired
    public PayPalService(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    public Payment createPayment(Double total, String currency, String method, String intent,
                                 String description, String cancelUrl, String successUrl) throws PayPalRESTException {

        Amount amount = new Amount(currency, String.format(Locale.forLanguageTag(currency), "%.2f", total));
        //create Transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(description);
        //create  payer
        Payer payer = new Payer();
        payer.setPaymentMethod(method); // sandbox for testing
        //create payment
        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(List.of(transaction));
        //create success and error redirectURLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setReturnUrl(successUrl);
        redirectUrls.setCancelUrl(cancelUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    //execute payment
    public Payment executePayment(String payerId, String paymentId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        return payment.execute(apiContext, paymentExecution);
    }
}
