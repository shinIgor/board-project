package com.example.boardproject.application.controller;

import com.example.boardproject.application.model.transfer.Dto.BoardListDto;
import com.example.boardproject.application.model.transfer.Request.BasePageRequest;
import com.example.boardproject.application.model.transfer.Response.BasePageResponse;
import com.example.boardproject.application.model.transfer.Response.BoardPostDetailResponse;
import com.example.boardproject.application.service.BoardService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigInteger;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PageController {
    private final BoardService boardService;

    @GetMapping("/main")
    public ModelAndView basePage(ModelAndView mnv) throws IOException {
        BasePageRequest param = new BasePageRequest();
        param.setPage(0);
        param.setPageSize(10);

        BasePageResponse<BoardListDto> boardList = boardService.getBoardList(param);
        mnv.addObject("boardList", boardList.getContents());

        mnv.setViewName("view/board/board");
        return mnv;
    }

    @GetMapping("/post/new")
    public ModelAndView boardNew(ModelAndView mnv) throws IOException {
        mnv.setViewName("view/board/board_new");
        return mnv;
    }

    @GetMapping("/post/{boardId}")
    public ModelAndView boardPage(ModelAndView mnv,
                                  @Valid @PathVariable(name = "boardId") BigInteger boardId) throws IOException {
        BoardPostDetailResponse boardDetail = boardService.getBoardPostDetail(boardId);
        mnv.addObject("boardDetail", boardDetail);

        mnv.setViewName("view/board/board_detail");
        return mnv;
    }
}
