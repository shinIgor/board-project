package com.example.boardproject.application.model.transfer.Request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class PageSortRequest extends BasePageRequest {
    String sortBy;

    Sort.Direction direction = Sort.Direction.DESC;

    public Sort makeSort() {
        return Sort.by(direction, sortBy);
    }
}
