package com.normdevstorm.commerce_platform.controller.transaction;

import com.normdevstorm.commerce_platform.dto.transaction.TransactionRequestDto;
import com.normdevstorm.commerce_platform.dto.transaction.TransactionResponseDto;
import com.normdevstorm.commerce_platform.enums.Status;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.impl.TransactionServiceImpl;
import com.paypal.api.payments.RedirectUrls;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/transaction")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Transaction",description = "Transaction management for users")
public class TransactionController {

    private TransactionServiceImpl transactionService;
    @Autowired
    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public  Object createTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        TransactionResponseDto transaction = transactionService.createTransaction(transactionRequestDto);
        if(transaction != null){
            //direct to paypal
            return new ModelAndView(  "forward:/payment/create?method=paypal&amount="+transaction.getTotal()+"&currency="+"USD"+"&description="+transaction.getDescription());
//                return new ModelAndView(new RedirectView("http://localhost:8080/normdevstorm/payment/create?method=paypal&amount="+transaction.getTotal()+"&currency="+"USD"+"&description="+transaction.getDescription()));
        }else
        return  ResponseEntity.ok(GenericResponse.builder().message("Create transaction failed !!!").success(false).data("Cannot redirect to payment process!!!").build());
//        return  ResponseEntity.ok(GenericResponse.<TransactionResponseDto>builder().message("Create transaction successfully !!!").success(true).data(transaction).build());
    }

    @PatchMapping("/update")
    public ResponseEntity<GenericResponse<TransactionResponseDto>> updateTransaction(@RequestParam("transactionId") String transactionid, @RequestParam("status")Status status){
        TransactionResponseDto transaction = transactionService.updateTransaction(transactionid, status);
        return  ResponseEntity.ok(GenericResponse.<TransactionResponseDto>builder().message("Update transaction successfully !!!").success(true).data(transaction).build());
    }

    @GetMapping("/all")
    public ResponseEntity<GenericResponse<Set<TransactionResponseDto>>> getAllTransactions(){
        Set<TransactionResponseDto> transactions = transactionService.getAllTransactions();
        return  ResponseEntity.ok(GenericResponse.<Set<TransactionResponseDto>>builder().message("Get transactions successfully !!!").success(true).data(transactions).build());
    }

    @GetMapping("/before")
    public ResponseEntity<GenericResponse<Set<TransactionResponseDto>>> getAllTransactionsBeforeTime(@RequestParam("time")LocalDateTime time){
        Set<TransactionResponseDto> transactions = transactionService.getAllTransactionsBeforeTime(time);
        return  ResponseEntity.ok(GenericResponse.<Set<TransactionResponseDto>>builder().message("Get transactions successfully !!!").success(true).data(transactions).build());
    }
}
