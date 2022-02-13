package honeyshop.controller.shop.section.blankhoney;

import honeyshop.service.blankhoney.BlankHoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/blankhoney",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class BlankHoneyController {

    private final BlankHoneyService blankHoneyService;

    @Autowired
    public BlankHoneyController(BlankHoneyService blankHoneyService) {
        this.blankHoneyService = blankHoneyService;
    }
}
