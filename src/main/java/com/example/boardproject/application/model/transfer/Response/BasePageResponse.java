package com.example.boardproject.application.model.transfer.Response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasePageResponse<T> {
    Integer currentPage = 0;
    Integer pageSize = 0;
    Integer totalPage = 0;
    Long totalElement = 0L;
    List<T> contents = new ArrayList<>();

    public BasePageResponse(List<T> param, Pageable pageable, Long count) {
        this.currentPage = pageable.getPageNumber() + 1;
        this.pageSize = pageable.getPageSize();
        this.totalPage = Math.toIntExact(getTotalPage(pageable.getPageSize(), pageable.getOffset()));
        this.totalElement = count;
        this.contents = param;
    }

    private Long getTotalPage(Integer pageSize, Long count) {
        if (count < pageSize.longValue()){
            return 1L;
        } else {
            long totalPage = count / pageSize.longValue();
            return totalPage;
        }
    }
}
