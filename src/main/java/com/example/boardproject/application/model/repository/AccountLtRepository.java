package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.AccountLt;
import com.example.boardproject.application.model.repository.querydsl.QAccountLtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface AccountLtRepository extends JpaRepository<AccountLt, BigInteger>, QAccountLtRepository {
}
