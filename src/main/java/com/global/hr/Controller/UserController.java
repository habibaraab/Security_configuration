package com.global.hr.Controller;

import com.global.hr.Model.AppUser;
import com.global.hr.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Data
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
   ResponseEntity<?> save(@RequestBody AppUser user) {
        return ResponseEntity.ok(userService.save(user));
    }



}
