package com.global.hr.Service;

import com.global.hr.Model.Role;
import com.global.hr.Repository.RoleRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;
    public List<Role> findAll(){
        return roleRepo.findAll();
    }
    public Role findById(Long id){
        return roleRepo.findById(id).orElse(null);
    }
    public Role findByName(String name){
        return roleRepo.findByName(name).orElse(null);
    }

    public Role save(Role role) {
        return roleRepo.save(role);
    }
}
