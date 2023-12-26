package com.example.boardproject.application.model.repository.querydsl;

import com.example.boardproject.application.model.transfer.Request.MemberRegistRequest;
import com.example.boardproject.application.model.transfer.Response.AssociateUserResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import jakarta.validation.constraints.NotNull;

public interface QAssociateUtRepository {

    Boolean registerUser(MemberRegistRequest memberRegistRequest);

    AssociateUserResponse loginAssociate(UserDataDto userDataDto);
}
