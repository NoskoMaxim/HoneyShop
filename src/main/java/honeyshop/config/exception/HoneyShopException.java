package honeyshop.config.exception.honeyshopexception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class HoneyShopException extends RuntimeException {

    private final Map<String, String> failures;
    private final HttpStatus status;

    public HoneyShopException(Map<String, String> failures, HttpStatus status) {
        this.failures = failures;
        this.status = status;
    }

    public Map<String, String> getFailures() {
        return failures;
    }

    public HttpStatus getStatus() {
        return status;
    }
}