package com.example.boardproject.application.model.repository.querydsl;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;

public interface QAccountUtRepository {
    AccountUt getAccount(String userId);
}
