package honeyshop.controller.user;

import honeyshop.dto.user.RoleToUserFormDto;
import honeyshop.dto.user.UsernameAndPasswordToCreateFormDto;
import honeyshop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/honeyshop")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/create",
            consumes = {APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@RequestBody UsernameAndPasswordToCreateFormDto createForm) {
        userService.createUser(createForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/user/get/all",
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping(value = "/user/get/{username}",
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUserByUsername(username));
    }

    @PostMapping(value = "/role/create")
    public ResponseEntity createRole(@RequestParam String roleName) {
        userService.createRole(roleName);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/role/add",
            consumes = {APPLICATION_JSON_VALUE})
    public ResponseEntity addRoleToUser(@RequestBody RoleToUserFormDto roleForm) {
        userService.addRoleToUser(roleForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/role/get/all",
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity getAllRoles() {
        return ResponseEntity.ok().body(userService.getAllRoles());
    }

    @GetMapping(value = "/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }
}
