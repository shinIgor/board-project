package com.example.boardproject.application.model.transfer.Request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@AllArgsConstructor
public class BaseSearchRequest {
    String type;

    String keyword;
}
