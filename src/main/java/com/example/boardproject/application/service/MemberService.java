package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;

public interface MemberService {
    Boolean isDuplicate(String userId);

    LoginResponse loginUser(UserDataDto param);

    Boolean registerUser(AccountRegisterRequest userDataDto);


}
