package com.example.boardproject.application.model.repository.querydsl;

import com.example.boardproject.application.model.entity.BoardUt;
import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardDetailResponse;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface QBoardUtRepository {
    List<BoardUt> getBoardList(Pageable pageable);

    Long getBoardCount(Pageable pageable);

    BoardUt getBoardDetail(BigInteger boardId);
}
