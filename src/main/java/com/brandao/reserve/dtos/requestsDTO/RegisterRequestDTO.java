package com.brandao.reserve.dtos.requestsDTO;

import java.util.ArrayList;
import java.util.List;

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
public class RegisterRequestDTO {
    
    private String name;
    private String email;
    private String password;
        
    @Builder.Default
    private List<String> roles = new ArrayList<>();

}

