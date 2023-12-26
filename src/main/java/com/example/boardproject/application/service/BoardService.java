package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Request.BasePageRequest;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardPostDetailResponse;

import java.math.BigInteger;

public interface BoardService {
    BasePageResponse<BoardListDto> getBoardList(BasePageRequest param);

    BoardPostDetailResponse getBoardPostDetail(BigInteger boardId);
}
