package com.brandao.reserve.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.requestsDTO.RestaurantTableRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.RestaurantTableResponseDTO;
import com.brandao.reserve.entities.RestaurantTable;
import com.brandao.reserve.entities.TableReservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestaurantTableMapper {

    public RestaurantTableResponseDTO toDTO(RestaurantTable entity){
        if(entity == null) return null;

        return RestaurantTableResponseDTO.builder()
        .id(entity.getId())
        .tableNumber(entity.getTableNumber())
        .capacity(entity.getCapacity())        
        .build();
    }

    public RestaurantTable toNewEntity(RestaurantTableRequestDTO dto){
        if (dto == null) return null;

        return RestaurantTable.builder()        
        .tableNumber(dto.getTableNumber())
        .capacity(dto.getCapacity())       
        .build();
    }

    public RestaurantTable toEntity(RestaurantTableResponseDTO dto){
        if (dto == null) return null;

        return RestaurantTable.builder()  
        .id(dto.getId())      
        .tableNumber(dto.getTableNumber())
        .capacity(dto.getCapacity())       
        .build();
    }  

    public List<RestaurantTableResponseDTO> getTablesDTO(List<TableReservation> tables){
        
        List<RestaurantTableResponseDTO> list = new ArrayList<>();

        for(TableReservation entity : tables){
            
            RestaurantTableResponseDTO dto = new RestaurantTableResponseDTO();
            dto.setId(entity.getRestaurantTable().getId());
            dto.setTableNumber(entity.getRestaurantTable().getTableNumber());
            dto.setCapacity(entity.getRestaurantTable().getCapacity());            
            list.add(dto);
        }

        return list;
    }  

}
