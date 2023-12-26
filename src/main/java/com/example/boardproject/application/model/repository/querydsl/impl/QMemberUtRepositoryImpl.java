package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.repository.querydsl.QMemberUtRepository;
import com.example.boardproject.application.model.transfer.Dto.MemberLoginDataDto;
import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.model.type.CheckDuplicateKeywordType;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.example.boardproject.application.model.entity.QMemberUt.memberUt;


@Slf4j
@RequiredArgsConstructor
public class QMemberUtRepositoryImpl implements QMemberUtRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Boolean checkValid(DuplicateKeywordRequest param) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(memberUt)
                        .where(valid(param))
                        .fetchOne())
                .isEmpty();
    }

    public LoginResponse loginUser(UserDataDto param) {
        MemberLoginDataDto memberLoginDataDto = jpaQueryFactory.select(Projections.constructor(MemberLoginDataDto.class,
                        memberUt.usn,
                        memberUt.userId,
                        memberUt.nickName,
                        memberUt.isDelete,
                        memberUt.permission

                ))
                .from(memberUt)
                .where(memberUt.userId.eq(param.getUserId()))
                .fetchFirst();
        return null;
    }

    private BooleanExpression valid(DuplicateKeywordRequest param) {
        if (CheckDuplicateKeywordType.ID.equals(param.getType()))
            return memberUt.userId.eq(param.getKeyword());

        if (CheckDuplicateKeywordType.NICK_NAME.equals(param.getType()))
            return memberUt.nickName.eq(param.getKeyword());

        log.error("Not found search keyword type. type: {}", param.getType());
        return null;
    }

}
