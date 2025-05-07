package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.model.transfer.Response.TokenResponse;
import com.example.boardproject.application.util.ValidCheck;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;

public interface MemberService {
    Boolean isDuplicate(String userId);

    TokenResponse loginUser(@NonNull @ValidCheck HttpServletRequest request, @NonNull @ValidCheck UserDataDto param);

    Boolean registerUser(AccountRegisterRequest userDataDto);


}
