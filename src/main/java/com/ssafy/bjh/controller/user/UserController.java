package com.ssafy.bjh.controller.user;

import com.ssafy.bjh.model.dto.User;
import com.ssafy.bjh.service.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin
@Tag(name = "User Controller", description = "Login, Logout API")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User isUserExisted = userService.login(user);

        if (Objects.isNull(isUserExisted)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(userService.login(user), HttpStatus.OK);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        boolean isSignup = userService.register(user);
        return isSignup ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.CONFLICT);
    }
}
