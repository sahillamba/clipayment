package com.coviam.payment.controller;

import com.coviam.payment.dto.BookingDTO;
import com.coviam.payment.dto.TransactionDTO;
import com.coviam.payment.entity.CardDetails;
import com.coviam.payment.entity.ProviderConfig;
import com.coviam.payment.entity.Transaction;
import com.coviam.payment.services.CardPaymentService;
import com.coviam.payment.services.ProviderService;
import com.coviam.payment.services.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by avinashkumar on 05/02/2018 AD.
 */
@RestController
@RequestMapping("/card")
public class CardPaymentController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    CardPaymentService cardPaymentService;
    @Autowired
    ProviderService providerService;

    @RequestMapping(
            value = "/makePayment",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> makePayment(@RequestBody TransactionDTO transactionDTO) {
        if(transactionDTO == null){
            return null;
        }

        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDTO, transaction);
        Transaction savedTransaction=transactionService.save(transaction);

        CardDetails cardDetails=new CardDetails();
        BeanUtils.copyProperties(transactionDTO.getCardDetailsDTO(),cardDetails);
        CardDetails savedCardDetails = cardPaymentService.save(cardDetails);

        ProviderConfig providerConfig = providerService.findOne(transaction.getProviderId());

        ResponseEntity<Boolean> paymentResponseEntity = cardPaymentService.pay(transactionDTO.getCardDetailsDTO(),providerConfig);

        if(paymentResponseEntity.getStatusCode()!=HttpStatus.OK){
            return new ResponseEntity<String>("payment failed", HttpStatus.NOT_ACCEPTABLE);
        }
        ResponseEntity<BookingDTO> bookingDTOResponseEntity = transactionService.processPayment(paymentResponseEntity,transaction);

        return bookingDTOResponseEntity;
    }
}
