package com.brandao.reserve.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.requestsDTO.RegisterRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.RegisterReponseDTO;
import com.brandao.reserve.entities.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
   
    @Autowired
    UserRolesMapper userRolesMapper;

    public RegisterReponseDTO toDTO(User entity) {
        if (entity == null)
            return null;

        return RegisterReponseDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .roles(userRolesMapper.rolesToDTO(entity.getRoles()))        
        .build();
    }

    public User toEntity(RegisterRequestDTO dto) {
        if (dto == null)
            return null;

            return User.builder()
            .name(dto.getName())
            .email(dto.getEmail())            
            .build();
    }   

}
