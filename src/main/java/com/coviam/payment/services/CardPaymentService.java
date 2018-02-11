package com.coviam.payment.services;

import com.coviam.payment.dto.CardDetailsDTO;
import com.coviam.payment.entity.CardDetails;
import com.coviam.payment.entity.ProviderConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface CardPaymentService {

    ResponseEntity<Boolean> pay(CardDetailsDTO cardDetailsDTO, ProviderConfig providerConfig);

    @Transactional(readOnly = false)
    CardDetails save(CardDetails cardDetails);

    CardDetails getCardDetails(String cardDetailsId);
}
