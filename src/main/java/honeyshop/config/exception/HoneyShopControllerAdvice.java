package honeyshop.config.exception;

import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HoneyShopControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {HoneyShopException.class})
    protected ResponseEntity handleDemoException(
            HoneyShopException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getFailures(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}