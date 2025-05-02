package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.repository.querydsl.QUserActiveLtRepository;
import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Response.AssociateUserResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class QUserActiveLtRepositoryImpl implements QUserActiveLtRepository {
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Boolean registerUser(AccountRegisterRequest memberRegistRequest) {
        return null;
    }

    @Override
    public AssociateUserResponse loginAssociate(UserDataDto userDataDto) {
        return null;
    }
}
