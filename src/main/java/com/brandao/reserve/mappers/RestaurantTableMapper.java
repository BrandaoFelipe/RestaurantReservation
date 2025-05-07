package com.brandao.reserve.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.RestaurantTableDTO;
import com.brandao.reserve.entities.RestaurantTable;
import com.brandao.reserve.entities.TableReservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestaurantTableMapper {

    public RestaurantTableDTO toDTO(RestaurantTable entity){
        if(entity == null) return null;

        return RestaurantTableDTO.builder()
        .id(entity.getId())
        .number(entity.getNumber())
        .capacity(entity.getCapacity())        
        .build();
    }

    public RestaurantTable toEntity(RestaurantTableDTO dto){
        if (dto == null) return null;

        return RestaurantTable.builder()
        .id(dto.getId())
        .number(dto.getNumber())
        .capacity(dto.getCapacity())       
        .build();
    }

    public RestaurantTable toNewEntity(RestaurantTableDTO dto){
        if (dto == null) return null;

        return RestaurantTable.builder()
        .number(dto.getNumber())
        .capacity(dto.getCapacity())
        .build();
    }

    public List<RestaurantTableDTO> getTablesDTO(List<TableReservation> tables){
        
        List<RestaurantTableDTO> list = new ArrayList<>();

        for(TableReservation entity : tables){
            
            RestaurantTableDTO dto = new RestaurantTableDTO();
            dto.setId(entity.getRestaurantTable().getId());
            dto.setNumber(entity.getRestaurantTable().getNumber());
            dto.setCapacity(entity.getRestaurantTable().getCapacity());            
            list.add(dto);
        }

        return list;
    }  

}
