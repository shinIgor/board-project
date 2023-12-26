package com.example.boardproject.application.model.transfer.Request;

import com.example.boardproject.application.model.type.CheckDuplicateKeywordType;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DuplicateKeywordRequest {
    CheckDuplicateKeywordType type;
    String keyword;
}