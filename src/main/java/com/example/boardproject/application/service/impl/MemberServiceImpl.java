package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.repository.UserActiveLtRepository;
import com.example.boardproject.application.model.repository.AccountUtRepository;
import com.example.boardproject.application.model.transfer.Request.DuplicateKeywordRequest;
import com.example.boardproject.application.model.transfer.Response.AssociateUserResponse;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.service.MemberService;
import com.example.boardproject.application.util.PreContionalUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final AccountUtRepository accountUtRepository;
    private final UserActiveLtRepository userActiveLtRepository;


    @Override
    public boolean checkValid(DuplicateKeywordRequest param) {
        PreContionalUtil.valid(param);

        return accountUtRepository.checkValid(param);
    }

    public LoginResponse loginUser(UserDataDto param) {
        PreContionalUtil.valid(param);

        LoginResponse loginResponse = accountUtRepository.loginUser(param);

        if (loginResponse == null) {
            AssociateUserResponse associateUserResponse = userActiveLtRepository.loginAssociate(param);
            if (associateUserResponse == null) {
                // TODO 회원정보 없음 처리.
            }
            loginResponse.setUserId(associateUserResponse.getUserId());
            loginResponse.setNickName("temp"+associateUserResponse.getUsn());
            loginResponse.setPermission(0);
        }

        return loginResponse;
    }
}
