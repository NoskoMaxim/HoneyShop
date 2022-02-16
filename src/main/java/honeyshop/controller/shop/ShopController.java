package honeyshop.controller.shop;

import honeyshop.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/honeyshop/shop",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping(value = "/allblankshoney")
    public ResponseEntity getAllBlanksHoney(){
        return ResponseEntity.ok().body(shopService.getAllBlanksHoney());
    }

    @GetMapping(value = "/allinventoriesbreekeeper")
    public ResponseEntity getAllInventoriesBeekeeper(){
        return ResponseEntity.ok().body(shopService.getAllInventoriesBeekeeper());
    }

    @GetMapping(value = "/allproductsbreekeeper")
    public ResponseEntity getAllProductsBeekeeper(){
        return ResponseEntity.ok().body(shopService.getAllProductsBeekeeper());
    }
}
