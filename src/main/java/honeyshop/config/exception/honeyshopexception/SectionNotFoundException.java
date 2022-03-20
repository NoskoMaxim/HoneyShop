package honeyshop.config.exception.honeyshopexception;

import honeyshop.config.exception.HoneyShopException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class SectionNotFoundException extends HoneyShopException {
    public SectionNotFoundException(Map<String, String> failures, HttpStatus status) {
        super(failures, status);
    }

    public SectionNotFoundException(Map<String, String> failures) {
        super(failures);
    }
}
