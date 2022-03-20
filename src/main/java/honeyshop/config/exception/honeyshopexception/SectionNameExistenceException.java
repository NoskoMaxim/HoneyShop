package honeyshop.config.exception.honeyshopexception;

import honeyshop.config.exception.HoneyShopException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class SectionNameExistenceException extends HoneyShopException {
    public SectionNameExistenceException(Map<String, String> failures, HttpStatus status) {
        super(failures, status);
    }

    public SectionNameExistenceException(Map<String, String> failures) {
        super(failures);
    }
}
