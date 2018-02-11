package com.coviam.payment.repository;

import com.coviam.payment.entity.ProviderConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderConfigRepository extends CrudRepository<ProviderConfig,String> {

    ProviderConfig findOne(String providerConfigId);
}
