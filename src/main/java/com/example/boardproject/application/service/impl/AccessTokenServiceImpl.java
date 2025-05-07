package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.transfer.Dto.Token.AccessToken;
import com.example.boardproject.application.model.transfer.Dto.Token.RefreshToken;
import com.example.boardproject.application.model.transfer.Response.TokenResponse;
import com.example.boardproject.application.service.AccessTokenService;
import com.example.boardproject.application.util.ValidCheck;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccessTokenServiceImpl implements AccessTokenService {

    @Override
    @ValidCheck
    public TokenResponse createAccessToken(HttpServletRequest request, AccountUt accountUt){
        AccessToken accessToken = new AccessToken(accountUt.getId());
        RefreshToken refreshToken = new RefreshToken(accountUt.getId());

        return new TokenResponse(accessToken,refreshToken,accountUt);
    }

    @Override
    @ValidCheck
    public TokenResponse refreshToken(HttpServletRequest request, String refreshTokenValue) {
        return null;
    }


}