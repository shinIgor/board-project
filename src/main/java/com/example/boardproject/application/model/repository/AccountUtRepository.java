package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.repository.querydsl.QAccountUtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface AccountUtRepository extends JpaRepository<AccountUt, BigInteger>, QAccountUtRepository {
    AccountUt findByUserId(String userId);
    AccountUt findByNickName(String nickName);
}
