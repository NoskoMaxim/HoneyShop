package honeyshop.controller.shop.section.inventorybeekeeper;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.service.inventorybeekeeper.InventoryBeekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/honeyshop/inventorybeekeeper",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class InventoryBeekeeperController {

    private final InventoryBeekeeperService inventoryBeekeeperService;

    @Autowired
    public InventoryBeekeeperController(InventoryBeekeeperService inventoryBeekeeperService) {
        this.inventoryBeekeeperService = inventoryBeekeeperService;
    }

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addInventoryBeekeeper(@RequestBody InventoryBeekeeperDto inventoryBeekeeperDto) {
        inventoryBeekeeperService.addInventoryBeekeeper(inventoryBeekeeperDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateInventoryBeekeeper(@RequestBody InventoryBeekeeperDto inventoryBeekeeperDto) {
        inventoryBeekeeperService.updateInventoryBeekeeper(inventoryBeekeeperDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{inventoryBeekeeperId}")
    public ResponseEntity deleteInventoryBeekeeper(@PathVariable Long inventoryBeekeeperId) {
        inventoryBeekeeperService.deleteInventoryBeekeeper(inventoryBeekeeperId);
        return ResponseEntity.ok().build();
    }
}
