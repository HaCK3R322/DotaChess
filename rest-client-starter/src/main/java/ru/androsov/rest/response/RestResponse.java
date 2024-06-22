package ru.androsov.rest.response;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import ru.androsov.rest.response.component.RestError;
import ru.androsov.rest.response.component.RestPagination;

import java.util.List;
import java.util.Objects;

@Getter
@ToString
@NoArgsConstructor
public final class RestResponse<T> {
    private T result;
    private RestPagination pagination;
    private List<RestError> errors;

    private RestResponse(T result, RestPagination pagination, List<RestError> errors) {
        this.result = result;
        this.pagination = pagination;
        this.errors = errors;
    }

    public static RestResponse<Void> success() {
        return new RestResponse<>(null, null, null);
    }

    public static <T> RestResponse<T> success(T result) {
        return new RestResponse<>(result, null, null);
    }

    public static <T> RestResponse<List<T>> success(Page<T> page) {
        return new RestResponse<>(page.getContent(), RestPagination.from(page), null);
    }

    public static <T> RestResponse<T> error(List<RestError> errors) {
        return new RestResponse<>(null, null, errors);
    }

    @JsonIgnore
    public boolean isOk() {
        return Objects.isNull(errors);
    }
}
