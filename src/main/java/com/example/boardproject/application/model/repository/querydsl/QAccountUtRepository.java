package com.example.boardproject.application.model.repository.querydsl;

import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;

public interface QAccountUtRepository {
    Boolean checkValid(DuplicateKeywordRequest param);

    LoginResponse loginUser(UserDataDto param);
}
