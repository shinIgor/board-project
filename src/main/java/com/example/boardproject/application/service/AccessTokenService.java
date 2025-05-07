package com.example.boardproject.application.service;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.transfer.Response.TokenResponse;
import jakarta.servlet.http.HttpServletRequest;


public interface AccessTokenService {
    TokenResponse createAccessToken(HttpServletRequest request, AccountUt accountUt);

    TokenResponse refreshToken(HttpServletRequest request, String refreshTokenValue);
}
