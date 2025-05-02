package com.example.boardproject.application.model.transfer.Request;

import com.example.boardproject.application.model.entity.AccountUt;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Optional;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountLoginRequest {
    @NotNull
    String userId;
    @NotNull
    String userPw;
    @NotNull
    Boolean isDuplicate;

    public AccountUt pick(AccountUt model) {
        Optional.ofNullable(model)
                .ifPresent(e -> {
                    e.setUserId(userId);
                });
        return model;
    }

    public Example<AccountUt> makeExample() {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        return Example.of(pick(new AccountUt()), matcher);
    }
}
