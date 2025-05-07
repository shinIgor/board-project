package com.example.boardproject.application.model.transfer.Response;

import com.example.boardproject.application.model.entity.AccountUt;
import com.example.boardproject.application.model.transfer.Dto.Token.AccessToken;
import com.example.boardproject.application.model.transfer.Dto.Token.RefreshToken;
import com.example.boardproject.application.model.type.AdditionalInformation;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenResponse {
    AccessToken accessToken;
    RefreshToken refreshToken;
    Map<String, Object> additionalInformation;

    public TokenResponse(AccessToken accessToken, RefreshToken refreshToken, AccountUt accountUt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;

        this.additionalInformation = new HashMap<>();
        if(accountUt != null) {
            this.additionalInformation.put(AdditionalInformation.USN.getName(), accountUt.getId());
            this.additionalInformation.put(AdditionalInformation.USER_ID.getName(), accountUt.getUserId());
            this.additionalInformation.put(AdditionalInformation.NICK_NAME.getName(), accountUt.getNickName());
            this.additionalInformation.put(AdditionalInformation.IS_CONNECT.getName(), true);
        } else {
            this.additionalInformation.put(AdditionalInformation.IS_CONNECT.getName(), false);
        }
    }
}
