package com.coviam.payment.services.impl;

import com.coviam.payment.entity.ProviderConfig;
import com.coviam.payment.repository.ProviderConfigRepository;
import com.coviam.payment.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderConfigRepository providerConfigRepository;

    @Override
    @Transactional(readOnly = false)
    public ProviderConfig save(ProviderConfig providerConfig) {
        return providerConfigRepository.save(providerConfig);
    }

    @Override
    public ProviderConfig findOne(String providerConfigId){
        return providerConfigRepository.findOne(providerConfigId);
    }

}
