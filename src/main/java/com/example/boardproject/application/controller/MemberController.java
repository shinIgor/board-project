package com.example.boardproject.application.controller;

import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Response.BaseResponse;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.model.transfer.Response.TokenResponse;
import com.example.boardproject.application.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public BaseResponse<TokenResponse> login(@Valid @RequestBody UserDataDto param, HttpServletRequest httpServletRequest){
        return BaseResponse.success(memberService.loginUser(httpServletRequest,param));
    }

    @PostMapping("/register")
    public BaseResponse<Boolean> createMember (@Valid @RequestBody AccountRegisterRequest param){
        return BaseResponse.success(memberService.registerUser(param));
    }

    @PostMapping("/register/duplicate")
    public BaseResponse<Boolean> checkDuplicate(@Valid @RequestBody String userId){
        return BaseResponse.success(memberService.isDuplicate(userId));
    }

    @DeleteMapping("/logout")
    public BaseResponse<Boolean> logout(){
        return BaseResponse.success(true);
    }

    @PutMapping("/update")
    public BaseResponse<Boolean> updateMember(){
        return  null;
    }


}
