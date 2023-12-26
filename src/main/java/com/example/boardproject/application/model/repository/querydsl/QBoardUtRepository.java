package com.example.boardproject.application.model.repository.querydsl;

import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardPostDetailResponse;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface QBoardUtRepository {
    BasePageResponse<BoardListDto> getBoardList(Pageable pageable);

    BoardPostDetailResponse getBoardList(BigInteger boardId);
}
