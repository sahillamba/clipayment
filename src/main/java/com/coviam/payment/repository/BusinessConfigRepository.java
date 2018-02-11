package com.coviam.payment.repository;

import com.coviam.payment.entity.BusinessConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessConfigRepository extends CrudRepository<BusinessConfig,String> {
}
