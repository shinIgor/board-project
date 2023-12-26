package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.AssociateUt;
import com.example.boardproject.application.model.entity.MemberUt;
import com.example.boardproject.application.model.repository.querydsl.QAssociateUtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AssociateUtRepository extends JpaRepository<AssociateUt, BigInteger>, QAssociateUtRepository {
    AssociateUt findByUserId(String userId);

}
