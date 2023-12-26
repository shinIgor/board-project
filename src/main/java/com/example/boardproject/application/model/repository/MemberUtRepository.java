package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.MemberUt;
import com.example.boardproject.application.model.repository.querydsl.QMemberUtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface MemberUtRepository extends JpaRepository<MemberUt, BigInteger>, QMemberUtRepository {
    MemberUt findByUserId(String userId);
    MemberUt findByNickName(String nickName);
}
