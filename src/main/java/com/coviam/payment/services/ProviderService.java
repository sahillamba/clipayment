package com.coviam.payment.services;


import com.coviam.payment.entity.ProviderConfig;

public interface ProviderService {

    public ProviderConfig save(ProviderConfig providerConfig);

    public ProviderConfig findOne(String providerConfigId);
}
