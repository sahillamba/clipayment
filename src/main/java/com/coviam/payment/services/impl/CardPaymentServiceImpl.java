package com.coviam.payment.services.impl;


import com.coviam.payment.dto.CardDetailsDTO;
import com.coviam.payment.entity.CardDetails;
import com.coviam.payment.entity.ProviderConfig;
import com.coviam.payment.repository.CardDetailsRepository;
import com.coviam.payment.services.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
public class CardPaymentServiceImpl implements CardPaymentService {

    @Autowired
    CardDetailsRepository cardDetailsRepository;

    @Override
    public ResponseEntity<Boolean> pay(CardDetailsDTO cardDetailsDTO, ProviderConfig providerConfig) {
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    @Override
    @Transactional(readOnly = false)
    public CardDetails save(CardDetails cardDetails) {
        return cardDetailsRepository.save(cardDetails);
    }

    @Override
    public CardDetails getCardDetails(String cardDetailsId) {
        return cardDetailsRepository.findOne(cardDetailsId);
    }

}
