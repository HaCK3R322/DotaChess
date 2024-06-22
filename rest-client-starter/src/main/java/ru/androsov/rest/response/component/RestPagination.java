package ru.androsov.rest.response.component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor
public final class RestPagination {

    private int size;
    private int total;
    private int page;
    private long count;

    private RestPagination(int size, int total, int page, long count) {
        this.size = size;
        this.total = total;
        this.page = page;
        this.count = count;
    }

    public static RestPagination from(Page page) {
        return new RestPagination(page.getSize(), page.getTotalPages(), page.getNumber(), page.getTotalElements());
    }
}
