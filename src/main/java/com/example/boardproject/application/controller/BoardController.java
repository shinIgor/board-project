package com.example.boardproject.application.controller;


import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Request.BasePageRequest;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BaseResponse;
import com.example.boardproject.application.model.transfer.Response.BoardListResponse;
import com.example.boardproject.application.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/v1/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("")
    public BaseResponse<BasePageResponse<BoardListResponse>> getBoardList(@Valid @ModelAttribute BasePageRequest param){
        return BaseResponse.success(boardService.getBoardList(param));
    }

}
