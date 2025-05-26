package com.brandao.reserve.dtos.responseDTOs;

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
public class RegisterReponseDTO {

    private Long id;
    private String name;
    private String email;

    @Builder.Default
    private String password = "[ENCRYPTED]";
    
    @Builder.Default
    private List<String> roles = new ArrayList<>();

}
