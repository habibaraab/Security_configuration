package com.global.hr.Service;

import com.global.hr.Model.AppUser;
import com.global.hr.Repository.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepo userRepo;
    public List<AppUser> findAll(){
        List<AppUser> users = userRepo.findAll();
        System.out.println(users.size());
        for (AppUser user : users) {
            System.out.println(user.getId()+" "+user.getFullName());
        }
        return users;

    }
    public AppUser findById(Long id){
        return userRepo.findById(id).orElse(null);
    }



    public AppUser save(AppUser appUser) {
        return userRepo.save(appUser);
    }
}
