package com.example.boardproject.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mnv) throws IOException {
        mnv.setViewName("view/board/board");
        return mnv;
    }
}
