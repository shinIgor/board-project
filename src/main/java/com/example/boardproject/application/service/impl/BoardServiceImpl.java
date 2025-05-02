package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.entity.BoardUt;
import com.example.boardproject.application.model.repository.BoardUtRepository;
import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Request.BasePageRequest;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardDetailResponse;
import com.example.boardproject.application.model.transfer.Response.BoardListResponse;
import com.example.boardproject.application.service.BoardService;
import com.example.boardproject.application.util.PreConditionalUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardUtRepository boardUtRepository;


    @Override
    public BasePageResponse<BoardListResponse> getBoardList(BasePageRequest param) {
        PreConditionalUtil.valid(param);
        Pageable pageable = param.makePageable();

        Long count = boardUtRepository.getBoardCount(pageable);
        if (0 == count) {
            log.warn("Board data is zero");
            return new BasePageResponse<>(null, pageable, count);
        }

        List<BoardListResponse> boardList = boardUtRepository.getBoardList(pageable)
                .stream()
                .map(BoardListResponse::of)
                .toList();

        return new BasePageResponse<>(boardList, pageable, 0L);
    }

    @Override
    public BoardDetailResponse getBoardPostDetail(BigInteger boardId) {
        PreConditionalUtil.valid(boardId);
        return null;
//        return boardUtRepository.getBoardList(boardId);
    }
}
