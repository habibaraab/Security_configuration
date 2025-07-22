package com.global.hr.Controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
@Data
public class TestRoles {

    @GetMapping("/admin")
    public ResponseEntity<String > admin () {
        return ResponseEntity.ok("allowed for all admins");
    }
    @GetMapping("/user")
    public ResponseEntity<String > user () {
        return ResponseEntity.ok("allowed for all users");
    }
    @GetMapping("/test")
    public ResponseEntity<String > test () {
        return ResponseEntity.ok("allowed for all ");
    }

}
