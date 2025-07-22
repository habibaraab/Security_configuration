//package com.global.hr.Config;
//
//import com.global.hr.Model.AppUser;
//import com.global.hr.Model.Role;
//import com.global.hr.Service.RoleService;
//import com.global.hr.Service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class StartUpApp implements CommandLineRunner {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RoleService roleService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (roleService.findAll().isEmpty()) {
//            roleService.save(new Role(  "admin"));
//            roleService.save(new Role("user"));
//            roleService.save(new Role("employee"));
//        }
//        if (userService.findAll().isEmpty()) {
//            Set<Role> adminRoles = new HashSet<>();
//            adminRoles.add(roleService.findByName("admin"));
//
//            Set<Role> userRoles = new HashSet<>();
//            userRoles.add(roleService.findByName("user"));
//
//            Set<Role> empRoles = new HashSet<>();
//            empRoles.add(roleService.findByName("employee"));
//
//            userService.save(new AppUser("Habiba Rajab", "bia", "123", adminRoles));
//
//            userService.save(new AppUser("ASmaa Mohamed", "ali", "123", userRoles));
//
//            userService.save(new AppUser( "Ahmed Ebraheem", "ahmed", "123", empRoles));
//        }
//    }
//}
//
