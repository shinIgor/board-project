package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.repository.BoardUtRepository;
import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Request.BasePageRequest;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardPostDetailResponse;
import com.example.boardproject.application.service.BoardService;
import com.example.boardproject.application.util.PreContionalUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardUtRepository boardUtRepository;


    @Override
    public BasePageResponse<BoardListDto> getBoardList(BasePageRequest param) {
        PreContionalUtil.valid(param);

        Pageable pageable = param.makePageable();
        return boardUtRepository.getBoardList(pageable);
    }

    @Override
    public BoardPostDetailResponse getBoardPostDetail(BigInteger boardId) {
        PreContionalUtil.valid(boardId);

        return boardUtRepository.getBoardList(boardId);
    }
}
