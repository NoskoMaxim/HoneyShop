package honeyshop.controller.shop;

import honeyshop.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/findblankshoneybyname")
    public ResponseEntity getBlankHoneyByName(@RequestParam String name){
        return ResponseEntity.ok().body(shopService.getBlankHoneyByName(name));
    }

    @GetMapping(value = "/allinventoriesbeekeeper")
    public ResponseEntity getAllInventoriesBeekeeper(){
        return ResponseEntity.ok().body(shopService.getAllInventoriesBeekeeper());
    }

    @GetMapping(value = "/findinventorybeekeeperbyname")
    public ResponseEntity getInventoryBeekeeperByName(@RequestParam String name){
        return ResponseEntity.ok().body(shopService.getInventoryBeekeeperByName(name));
    }

    @GetMapping(value = "/allproductsbeekeeper")
    public ResponseEntity getAllProductsBeekeeper(){
        return ResponseEntity.ok().body(shopService.getAllProductsBeekeeper());
    }

    @GetMapping(value = "/findproductbeekeeperbyname")
    public ResponseEntity getProductsBeekeeperByName(@RequestParam String name){
        return ResponseEntity.ok().body(shopService.getProductsBeekeeperByName(name));
    }
}
