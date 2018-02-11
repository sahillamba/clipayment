package com.coviam.payment.repository;


import com.coviam.payment.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,String> {

    @Query(value = "SELECT T FROM Transaction T WHERE T.customerId = :userId")
    List<Transaction> findByUserId(@Param("userId") String userId);
}
