package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;

public interface AssociateService {
    boolean registerUser(AccountRegisterRequest userDataDto);

//    AssociateUserResponse loginAssociate(UserDataDto userDataDto);
}
