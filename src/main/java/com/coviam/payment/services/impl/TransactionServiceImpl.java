package com.coviam.payment.services.impl;


import com.coviam.payment.dto.BookingDTO;
import com.coviam.payment.dto.UpdateBookingRequestDTO;
import com.coviam.payment.entity.Transaction;
import com.coviam.payment.repository.TransactionRepository;
import com.coviam.payment.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionServiceImpl implements TransactionService {

    @Value("${endpoint.updateBookingPayment}")
    private String updateBookingPayment;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction findOne(String transactionId) {
        return transactionRepository.findOne(transactionId);
    }

    @Override
    public List<Transaction> getTransactionsDetail(String userId) {
        List<Transaction> transactionList = transactionRepository.findByUserId(userId);
        return transactionList;
    }

    @Override
    public ResponseEntity<BookingDTO> processPayment(ResponseEntity<Boolean> paymentResponseEntity, Transaction transaction) {

        Transaction.Status paymentStatus;
        final String uriString = updateBookingPayment;
        if (paymentResponseEntity.getStatusCode() != HttpStatus.OK) {
            paymentStatus = Transaction.Status.DEFERRED;
        }else{
            paymentStatus = Transaction.Status.SUCCESSFUL;
        }

        transaction.setPaymentStatus(paymentStatus);
        Transaction updatedTransaction = save(transaction);

        UpdateBookingRequestDTO updateBookingRequestDTO = new UpdateBookingRequestDTO.Builder().superPnr(updatedTransaction.getSuperPnr()).paymentid(updatedTransaction.getId()).status(updatedTransaction.getPaymentStatus()).build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<UpdateBookingRequestDTO> entity = new HttpEntity<UpdateBookingRequestDTO>(updateBookingRequestDTO, headers);
        ResponseEntity<BookingDTO> bookingResponse = restTemplate.exchange(uriString, HttpMethod.POST, entity, BookingDTO.class);

        return bookingResponse;

    }

}

