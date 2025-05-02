package com.example.boardproject.application.model.transfer.Response;

import com.example.boardproject.application.model.exception.BaseError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor(staticName = "of")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseResponse<T> {
    Boolean success;
    BaseError error;
    T payload;

    public static <T> BaseResponse<T> success() {
        return BaseResponse.of(true, null, null);
    }
    public static <T> BaseResponse<T> success(T payload){return BaseResponse.of(true, null, payload);}
    public static <T> BaseResponse<T> fail(BaseError error) {
        return BaseResponse.of(false, error, null);
    }

}
