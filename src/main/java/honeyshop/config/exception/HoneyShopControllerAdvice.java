package honeyshop.config.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HoneyShopControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {HoneyShopException.class})
    protected ResponseEntity handleHoneyShopException(
            HoneyShopException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getFailures(),
                new HttpHeaders(), ex.getStatus(), request);
    }
}