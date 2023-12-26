package com.example.boardproject.application.model.repository.querydsl.impl;

import com.example.boardproject.application.model.repository.querydsl.QBoardUtRepository;
import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Dto.BoardPostDetailDto;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardPostDetailResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.boardproject.application.model.entity.QBoardUt.boardUt;
import static com.example.boardproject.application.model.entity.QMemberUt.memberUt;

@RequiredArgsConstructor
public class QBoardUtRepositoryImpl implements QBoardUtRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public BasePageResponse<BoardListDto> getBoardList(Pageable pageable) {
        List<BoardListDto> boardListDto = jpaQueryFactory.select(Projections.constructor(BoardListDto.class,
                        boardUt.id,
                        boardUt.usn,
                        memberUt.nickName,
                        boardUt.title,
                        boardUt.createdAt
                ))
                .from(boardUt)
                .join(memberUt)
                .on(boardUt.usn.eq(memberUt.usn))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = jpaQueryFactory.select(boardUt.count())
                .from(boardUt)
                .fetchOne();

        return new BasePageResponse<>(boardListDto, pageable, count);
    }

    @Override
    public BoardPostDetailResponse getBoardList(BigInteger boardId) {
        BoardPostDetailDto boardPostDetailDto = jpaQueryFactory.select(Projections.constructor(BoardPostDetailDto.class,
                        boardUt.id,
                        boardUt.usn,
                        memberUt.nickName,
                        memberUt.userId,
                        boardUt.title,
                        boardUt.post,
                        boardUt.createdAt,
                        boardUt.updatedAt))
                .from(boardUt)
                .join(memberUt)
                .on(boardUt.usn.eq(memberUt.usn))
                .where(boardUt.id.eq(boardId))
                .limit(1)
                .fetchFirst();

        return new BoardPostDetailResponse()
                .setId(boardPostDetailDto.getId())
                .setUsn(boardPostDetailDto.getUsn())
                .setNickName(boardPostDetailDto.getNickName())
                .setUserId(boardPostDetailDto.getUserId())
                .setTitle(boardPostDetailDto.getTitle())
                .setPost(boardPostDetailDto.getPost())
                .setCreatedAt(boardPostDetailDto.getCreatedAt())
                .setUpdatedAt(boardPostDetailDto.getUpdatedAt())
                ;
    }
}
