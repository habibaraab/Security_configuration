package com.global.hr.Controller;

import com.global.hr.Service.RoleService;
import com.global.hr.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
@Data
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ) {

        return ResponseEntity.ok(roleService.findById(id));
    }

}

