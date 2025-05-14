package com.brandao.reserve.mappers;

import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.requestsDTO.ClientRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.ClientResponseDTO;
import com.brandao.reserve.entities.Client;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class ClientMapper {

    public ClientResponseDTO toDTO(Client entity){
        if (entity == null) return null;

        return ClientResponseDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .cpf(entity.getCpf())
        .email(entity.getEmail())
        .phoneNumber(entity.getPhoneNumber())
        .build();       
    }

    public Client toEntity(ClientRequestDTO dto){
        if(dto == null) return null;

        return Client.builder()
        .name(dto.getName())
        .cpf(dto.getCpf())
        .email(dto.getEmail())
        .phoneNumber(dto.getPhoneNumber())
        .build();
    }

    
    public Client UpdateDtoToEntity(ClientRequestDTO dto, Client entity){
        if(dto == null || entity == null) return null;
        
        return entity.toBuilder()
        .name(dto.getName())
        .email(dto.getEmail())
        .phoneNumber(dto.getPhoneNumber())
        .build();
    }
}