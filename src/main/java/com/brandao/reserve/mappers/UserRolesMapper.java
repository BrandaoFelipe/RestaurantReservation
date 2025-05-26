package com.brandao.reserve.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.brandao.reserve.entities.Roles;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRolesMapper { 

    public List<String> rolesToDTO(Set<Roles> roles){
        
        List<String> list = new ArrayList<>();

        for(Roles entity : roles){
                      
            list.add(entity.getUserRole());
        }

        return list;
    }  


}
