package honeyshop.controller.shop.section.inventorybeekeeper;

import honeyshop.service.inventorybeekeeper.InventoryBeekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inventorybeekeeper",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class InventoryBeekeeperController {

    private final InventoryBeekeeperService inventoryBeekeeperService;

    @Autowired
    public InventoryBeekeeperController(InventoryBeekeeperService inventoryBeekeeperService) {
        this.inventoryBeekeeperService = inventoryBeekeeperService;
    }
}
