package com.brandao.reserve.dtos.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientResponseDTO {
    
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;
    
}
