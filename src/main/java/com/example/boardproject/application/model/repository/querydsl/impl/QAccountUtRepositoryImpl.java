package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.repository.querydsl.QAccountUtRepository;
import com.example.boardproject.application.util.ValidCheck;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.example.boardproject.application.model.entity.QAccountUt.accountUt;


@Slf4j
@RequiredArgsConstructor
public class QAccountUtRepositoryImpl implements QAccountUtRepository {
    private final JPAQueryFactory jpaQueryFactory;



    @Override
    @ValidCheck
    public AccountUt getAccount(String userId) {
        return jpaQueryFactory.select(accountUt)
                .from(accountUt)
                .leftJoin(accountUt.boardList)
                .fetchJoin()
                .where(accountUt.userId.eq(userId))
                .fetchFirst();
    }
}
