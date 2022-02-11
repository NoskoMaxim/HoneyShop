package honeyshop.config.exception.honeyshopexception;

import java.util.Map;

public class HoneyShopException extends RuntimeException {

    private Map<String,String> failures;

    public HoneyShopException(Map<String, String> failures) {
        this.failures = failures;
    }

    public Map<String, String> getFailures() {
        return failures;
    }
}