package com.example.boardproject.application.model.repository.querydsl;

import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Response.AssociateUserResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;

public interface QUserActiveLtRepository {

    Boolean registerUser(AccountRegisterRequest memberRegistRequest);

    AssociateUserResponse loginAssociate(UserDataDto userDataDto);
}
