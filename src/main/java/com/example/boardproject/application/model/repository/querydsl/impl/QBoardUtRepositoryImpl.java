package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.entity.BoardUt;
import com.example.boardproject.application.model.repository.querydsl.QBoardUtRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

import static com.example.boardproject.application.model.entity.QBoardUt.boardUt;

@RequiredArgsConstructor
public class QBoardUtRepositoryImpl implements QBoardUtRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BoardUt> getBoardList(Pageable pageable) {
        return jpaQueryFactory.select(boardUt)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }

    @Override
    public Long getBoardCount(Pageable pageable) {
        return jpaQueryFactory.select(boardUt.count())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchFirst();
    }

    @Override
    public BoardUt getBoardDetail(BigInteger boardId)    {
        return jpaQueryFactory.select(boardUt)
                .where(boardUt.id.eq(boardId))
                .fetchFirst();
    }
}
