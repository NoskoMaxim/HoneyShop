package honeyshop.controller.shop.section.productbeekeeping;

import honeyshop.dto.OperationMessageDto;
import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.service.productbeekeeping.ProductBeekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/honeyshop/sections/productbeekeeper",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductBeekeeperController {

    private final ProductBeekeeperService productBeekeeperService;

    @Autowired
    public ProductBeekeeperController(ProductBeekeeperService productBeekeeperService) {
        this.productBeekeeperService = productBeekeeperService;
    }

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addProductBeekeeper(@RequestBody ProductBeekeeperDto productBeekeeperDto) {
        productBeekeeperService.addProductBeekeeper(productBeekeeperDto);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @PutMapping(value = "/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateProductBeekeeper(@RequestBody ProductBeekeeperDto productBeekeeperDto) {
        productBeekeeperService.updateProductBeekeeper(productBeekeeperDto);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @DeleteMapping(value = "/delete/{productBeekeeperId}")
    public ResponseEntity deleteProductBeekeeper(@PathVariable Long productBeekeeperId) {
        productBeekeeperService.deleteProductBeekeeper(productBeekeeperId);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }
}
