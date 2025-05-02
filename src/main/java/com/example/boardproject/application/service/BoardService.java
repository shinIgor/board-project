package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Request.BasePageRequest;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardDetailResponse;
import com.example.boardproject.application.model.transfer.Response.BoardListResponse;

import java.math.BigInteger;

public interface BoardService {
    BasePageResponse<BoardListResponse> getBoardList(BasePageRequest param);

    BoardDetailResponse getBoardPostDetail(BigInteger boardId);
}
