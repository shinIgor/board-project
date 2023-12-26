package com.example.boardproject.application.model.transfer.Response;

import com.example.boardproject.application.model.transfer.Dto.AssociateLoginDto;
import com.example.boardproject.application.model.transfer.Dto.MemberLoginDataDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.Objects;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false)
public class LoginResponse {
    BigInteger usn;
    String userId;
    String nickName;
    Boolean isDelete;
    Integer permission;

    public LoginResponse bringMember(MemberLoginDataDto subOrder) {
        if (false == Objects.isNull(subOrder)) {
            setUsn(subOrder.getUsn());
            setUserId(subOrder.getUserId());
            setNickName(subOrder.getNickName());
            setIsDelete(subOrder.getIsDelete());
            setPermission(subOrder.getPermission());
        }
        return this;
    }

    public LoginResponse bringAssociate(AssociateLoginDto subOrder) {
        if (false == Objects.isNull(subOrder)) {
            setUsn(subOrder.getUsn());
            setUserId(subOrder.getUserId());
            setNickName("임시닉네임"+subOrder.getUsn());
            setIsDelete(subOrder.getType() == 1);
            setPermission(0);
        }
        return this;
    }
}