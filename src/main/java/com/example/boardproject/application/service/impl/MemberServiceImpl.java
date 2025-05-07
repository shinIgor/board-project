package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.define.RedisCacheKeyDefine;
import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.exception.CommonErrorMessage;
import com.example.boardproject.application.model.exception.CommonException;
import com.example.boardproject.application.model.repository.UserActiveLtRepository;
import com.example.boardproject.application.model.repository.AccountUtRepository;
import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
import com.example.boardproject.application.model.transfer.Response.LoginResponse;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.model.transfer.Response.TokenResponse;
import com.example.boardproject.application.service.AccessTokenService;
import com.example.boardproject.application.service.MemberService;
import com.example.boardproject.application.service.RedisCacheService;
import com.example.boardproject.application.util.ValidCheck;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final AccountUtRepository accountUtRepository;
    private final AccessTokenService accessTokenService;
    private final RedisCacheService redisCacheService;
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
    public TokenResponse loginUser(@NonNull @ValidCheck HttpServletRequest request, @NonNull @ValidCheck UserDataDto param) {
        AccountUt account = accountUtRepository.getAccount(param.getUserId());
        if (Objects.isNull(account)) {
            log.error("Failed to login. Invalid Id or Password. ID: {}", param.getUserId());
            throw new CommonException(CommonErrorMessage.INVALID_PARAM);
        }
        //TODO account pw param.pw 비교하는 로직.
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isMatch = encoder.matches(param.getUserPw(), account.getPasswordValue());
        if (false == isMatch) {
            log.error("Failed to login. Password is not match. ID: {}", param.getUserId());
            throw new CommonException(CommonErrorMessage.INVALID_PARAM);
        }
        //TODO 로그인 완료 시 첫번째 Board 내용 캐시.
        if (!account.getBoardList().isEmpty()) {
            redisCacheService.setValue(
                    RedisCacheKeyDefine.getMemberKey(
                            account.getId()),
                    account.getBoardList(),
                    1,
                    TimeUnit.HOURS);
        }

        //TODO 로그인 완료시 JWT Token 생성 및 발급.
        TokenResponse tokenResponse = accessTokenService.createAccessToken(request, account);

        return tokenResponse;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(param.getUserPw());
        AccountUt result = accountUtRepository.save(
                AccountUt.builder()
                        .userId(param.getUserId())
                        .passwordKey(hashPassword)
                        .passwordValue(hashPassword)
                        .nickName(param.getNickName())
                        .build()
        );

        if (Objects.isNull(result)) {
            log.error("Failed to register new account. userId:{}, nickName: {}", param.getUserId(), param.getNickName());
            throw new CommonException(CommonErrorMessage.BAD_REQUEST);
        }

        return true;
    }
}
