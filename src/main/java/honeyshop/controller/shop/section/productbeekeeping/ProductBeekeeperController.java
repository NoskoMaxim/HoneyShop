package honeyshop.controller.shop.section.productbeekeeping;

import honeyshop.service.productbeekeeping.ProductBeekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/productbeekeeping",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class ProductBeekeeperController {

    private final ProductBeekeeperService productBeekeeperService;

    @Autowired
    public ProductBeekeeperController(ProductBeekeeperService productBeekeeperService) {
        this.productBeekeeperService = productBeekeeperService;
    }
}
