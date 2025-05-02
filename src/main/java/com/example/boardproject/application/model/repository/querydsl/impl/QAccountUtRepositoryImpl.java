package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.repository.querydsl.QAccountUtRepository;
import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequiredArgsConstructor
public class QAccountUtRepositoryImpl implements QAccountUtRepository {
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Boolean checkValid(DuplicateKeywordRequest param) {
        return null;
    }

    @Override
    public LoginResponse loginUser(UserDataDto param) {
        return null;
    }
}
