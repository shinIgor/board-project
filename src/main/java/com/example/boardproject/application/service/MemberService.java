package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;

public interface MemberService {
    boolean checkValid(DuplicateKeywordRequest param);

    LoginResponse loginUser(UserDataDto param);

}
