package honeyshop.controller.shop.section.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.service.blankhoney.BlankHoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/honeyshop/blankhoney",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class BlankHoneyController {

    private final BlankHoneyService blankHoneyService;

    @Autowired
    public BlankHoneyController(BlankHoneyService blankHoneyService) {
        this.blankHoneyService = blankHoneyService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity addBlankHoney(@RequestBody BlankHoneyDto blankHoneyDto) {
        blankHoneyService.addBlankHoney(blankHoneyDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateBlankHoney(@RequestBody BlankHoneyDto blankHoneyDto) {
        blankHoneyService.updatePublication(blankHoneyDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{blankHoneyId}")
    public ResponseEntity deleteBlankHoney(@PathVariable Long blankHoneyId) {
        blankHoneyService.deleteBlankHoney(blankHoneyId);
        return ResponseEntity.ok().build();
    }
}
