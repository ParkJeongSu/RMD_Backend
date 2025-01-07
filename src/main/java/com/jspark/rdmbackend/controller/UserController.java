package com.jspark.rdmbackend.controller;

import com.jspark.rdmbackend.Util.JwtUtil;
import com.jspark.rdmbackend.dto.UserprofileDto;
import com.jspark.rdmbackend.entity.Userprofile;
import com.jspark.rdmbackend.service.UserprofileService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserprofileService userprofileService;

    public UserController(UserprofileService userprofileService) {
        this.userprofileService = userprofileService;
    }

    @GetMapping
    public List<Userprofile> getAllUsers() {
        return userprofileService.getAllUsersprofile();
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Userprofile> getUserById(@PathVariable String userName) {
        Optional<Userprofile> user = userprofileService.getUserprofileByUserName(userName);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Userprofile createUserprofile(@RequestBody UserprofileDto userDto) {
        return userprofileService.createUserprofile(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUserprofile(@RequestBody UserprofileDto userDto) {
        String token = userprofileService.loginUserprofile(userDto);

        if(StringUtils.hasLength(token))
        {
            return ResponseEntity.ok().body(Map.of("token",token));
        }
        else
        {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userName) {
        userprofileService.deleteUserprofile(userName);
        return ResponseEntity.noContent().build();
    }
}
