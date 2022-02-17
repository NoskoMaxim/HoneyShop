package honeyshop.controller.shop.section.blankhoney;

import honeyshop.dto.OperationMessageDto;
import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.service.blankhoney.BlankHoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/honeyshop/sections/blankhoney",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class BlankHoneyController {

    private final BlankHoneyService blankHoneyService;

    @Autowired
    public BlankHoneyController(BlankHoneyService blankHoneyService) {
        this.blankHoneyService = blankHoneyService;
    }

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addBlankHoney(@RequestBody BlankHoneyDto blankHoneyDto) {
        blankHoneyService.addBlankHoney(blankHoneyDto);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @PutMapping(value = "/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateBlankHoney(@RequestBody BlankHoneyDto blankHoneyDto) {
        blankHoneyService.updateBlankHoney(blankHoneyDto);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @DeleteMapping(value = "/delete/{blankHoneyId}")
    public ResponseEntity deleteBlankHoney(@PathVariable Long blankHoneyId) {
        blankHoneyService.deleteBlankHoney(blankHoneyId);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }
}
