package com.example.boardproject.application.controller;

import com.example.boardproject.application.model.transfer.Request.MemberRegistRequest;
import com.example.boardproject.application.model.transfer.Response.BaseResponse;
import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.service.AssociateService;
import com.example.boardproject.application.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/v1/member")
public class MemberController {
    private final MemberService memberService;
    private final AssociateService associateService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@Valid @RequestBody UserDataDto param){
        return BaseResponse.success(memberService.loginUser(param));
    }

    @PostMapping("/register")
    public BaseResponse<Boolean> createMember (@Valid @RequestBody MemberRegistRequest param){
        return BaseResponse.success(associateService.registerUser(param));
    }

    @PostMapping("/validate")
    public BaseResponse<Boolean> checkValid(@Valid @RequestBody DuplicateKeywordRequest param){
        return BaseResponse.success(memberService.checkValid(param));
    }

    @PutMapping("/update")
    public BaseResponse<Boolean> updateMember(){
        return  null;
    }


}
