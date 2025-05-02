package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.UserActiveLt;
import com.example.boardproject.application.model.repository.querydsl.QUserActiveLtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserActiveLtRepository extends JpaRepository<UserActiveLt, BigInteger>, QUserActiveLtRepository {
    UserActiveLt findByUserId(String userId);

}
