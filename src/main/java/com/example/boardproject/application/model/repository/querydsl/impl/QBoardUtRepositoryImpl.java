package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.repository.querydsl.QBoardUtRepository;
import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardPostDetailResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

@RequiredArgsConstructor
public class QBoardUtRepositoryImpl implements QBoardUtRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public BasePageResponse<BoardListDto> getBoardList(Pageable pageable) {
        return null;
    }

    @Override
    public BoardPostDetailResponse getBoardList(BigInteger boardId) {
        return null;
    }
}
