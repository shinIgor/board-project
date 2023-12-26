package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.entity.QAssociateUt;
import com.example.boardproject.application.model.repository.querydsl.QAssociateUtRepository;
import com.example.boardproject.application.model.transfer.Request.MemberRegistRequest;
import com.example.boardproject.application.model.transfer.Response.AssociateUserResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.boardproject.application.model.entity.QMemberUt.memberUt;


@RequiredArgsConstructor
public class QAssociateUtRepositoryImpl implements QAssociateUtRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Boolean registerUser(MemberRegistRequest memberRegistRequest) {

        long result = jpaQueryFactory.insert(QAssociateUt.associateUt)
                .columns(QAssociateUt.associateUt.userId,
                        QAssociateUt.associateUt.userPw,
                        QAssociateUt.associateUt.type)
                .values(memberRegistRequest.getUserId(),
                        memberRegistRequest.getUserPw(),
                        0)
                .execute();

        return 0 != result;
    }

    public AssociateUserResponse loginAssociate(UserDataDto userDataDto) {
        return jpaQueryFactory.select(Projections.constructor(AssociateUserResponse.class,
                        memberUt.usn,
                        memberUt.userId
                ))
                .where(memberUt.userId.eq(userDataDto.getUserId()))
                .fetchFirst();
    }
}
