package com.example.boardproject.application.service;

import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.model.transfer.Request.MemberRegistRequest;

public interface AssociateService {
    boolean registerUser(MemberRegistRequest userDataDto);

//    AssociateUserResponse loginAssociate(UserDataDto userDataDto);
}
