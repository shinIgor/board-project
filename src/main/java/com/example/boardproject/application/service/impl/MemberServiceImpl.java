package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.exception.CommonErrorMessage;
import com.example.boardproject.application.model.exception.CommonException;
import com.example.boardproject.application.model.repository.UserActiveLtRepository;
import com.example.boardproject.application.model.repository.AccountUtRepository;
import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.service.MemberService;
import com.example.boardproject.application.util.ValidCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final AccountUtRepository accountUtRepository;
    private final UserActiveLtRepository userActiveLtRepository;


    @Override
    @ValidCheck
    public Boolean isDuplicate(String userId) {
        AccountUt account = accountUtRepository.getAccount(userId);
        if (!Objects.isNull(account)) {
            log.warn("Duplicate Id will be register");
            return true;
        }
        return false;
    }

    @Override
    @ValidCheck
    public LoginResponse loginUser(UserDataDto param) {
        AccountUt account = accountUtRepository.getAccount(param.getUserId());

        //TODO account pw param.pw 비교하는 로직.

        //TODO 로그인 완료 시 첫번째 Board 내용 캐시.

        return LoginResponse.of(account);
    }

    @Override
    @ValidCheck
    @Transactional
    public Boolean registerUser(AccountRegisterRequest param) {
        Boolean isDuplicate = isDuplicate(param.getUserId());
        if (isDuplicate) {
            log.error("Register Id is duplicate id. duplicateId: {}", param.getUserId());
            throw new CommonException(CommonErrorMessage.INVALID_PARAM);
        }

        //TODO Password 암호화
        AccountUt result = accountUtRepository.save(
                AccountUt.builder()
                .userId(param.getUserId())
                .passwordKey(param.getUserPw())
                .passwordValue(param.getUserPw())
                .nickName(param.getNickName())
                .build()
        );

        if (Objects.isNull(result)){
            log.error("Failed to register new account. userId:{}, nickName: {}", param.getUserId(), param.getNickName());
            throw new CommonException(CommonErrorMessage.BAD_REQUEST);
        }

        return true;
    }
}
