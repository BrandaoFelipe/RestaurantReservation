package com.brandao.reserve.dtos;

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
public class ClientDTO {

    private Long id;

    private String name;
    
    private String email;

    private String phoneNumber;
      
    @Builder.Default
    private List<ReservationMinimalDTO> reservations = new ArrayList<>();
}
