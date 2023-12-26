package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.MemberUt;
import com.example.boardproject.application.model.repository.querydsl.QMemberHtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface MemberHtRepository extends JpaRepository<MemberUt, BigInteger>, QMemberHtRepository {
}
