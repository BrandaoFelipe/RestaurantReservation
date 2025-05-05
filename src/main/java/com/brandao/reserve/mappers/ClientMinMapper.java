package com.brandao.reserve.mappers;

import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.ClientMinDTO;
import com.brandao.reserve.entities.Client;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientMinMapper {

    public ClientMinDTO toDTO(Client entity){
        if (entity == null) return null;

        return ClientMinDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .phoneNumber(entity.getPhoneNumber())       
        .build();
    }

    public Client toEntity(ClientMinDTO dto){
        if(dto == null) return null;

        return Client.builder()
        .id(dto.getId())
        .name(dto.getName())
        .email(dto.getEmail())
        .phoneNumber(dto.getPhoneNumber())
        .build();
    }    
    
}
