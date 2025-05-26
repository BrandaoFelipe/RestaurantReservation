package com.brandao.reserve.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brandao.reserve.dtos.requestsDTO.RegisterRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.RegisterReponseDTO;
import com.brandao.reserve.entities.Roles;
import com.brandao.reserve.entities.User;
import com.brandao.reserve.mappers.UserMapper;
import com.brandao.reserve.repositories.RolesRepository;
import com.brandao.reserve.repositories.UserRepository;
import com.brandao.reserve.services.exceptions.NotAllawedException;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Autowired
    private AuthService authService;

    

    @Transactional
    public RegisterReponseDTO register(RegisterRequestDTO dto){

         if(authService.loadUserByUsername(dto.getEmail()) != null) 
            throw new NotAllawedException("Login already in use");

        String passwordEncoder = passEncoder.encode(dto.getPassword());

        Set<Roles>rolesToEntity = new HashSet<>();        
       
        User user = mapper.toEntity(dto);

        rolesToEntity.addAll(rolesRepository.getRoleByName(dto.getRoles()));

        user.setPassword(passwordEncoder);  
        
        user.setRoles(rolesToEntity); 

        repository.save(user);

        RegisterReponseDTO response = mapper.toDTO(user);

        return response;
    }

   
}
