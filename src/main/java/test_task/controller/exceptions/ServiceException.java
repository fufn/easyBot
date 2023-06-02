package test_task.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test_task.payload.codes.ErrorCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends RuntimeException {

    protected String message;
    protected ErrorCode errorCode;
}
