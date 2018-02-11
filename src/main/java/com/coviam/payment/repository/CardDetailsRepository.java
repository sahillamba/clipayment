package com.coviam.payment.repository;

import com.coviam.payment.entity.CardDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends CrudRepository<CardDetails,String> {

}
