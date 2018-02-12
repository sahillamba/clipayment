package com.coviam.payment.controller;

import com.coviam.payment.dto.TransactionDTO;
import com.coviam.payment.entity.Transaction;
import com.coviam.payment.services.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by avinashkumar on 05/02/2018 AD.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(
            value = "/getTransactionsDetail/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getTransactionsDetail(@PathVariable("userId") String userId) {
        List<Transaction> transactionList = transactionService.getTransactionsDetail(userId);
        if(transactionList.size()==0){
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
        List<TransactionDTO> transactionDTOlist = new LinkedList<TransactionDTO>();
        transactionList.forEach(transaction -> {
            TransactionDTO transactionDTO = new TransactionDTO();
            BeanUtils.copyProperties(transaction, transactionDTO);
            transactionDTOlist.add(transactionDTO);
        });
        return new ResponseEntity<List<TransactionDTO>>(transactionDTOlist, HttpStatus.OK);
    }

}
