package com.brandao.reserve.dtos.requestsDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class ClientRequestDTO {

    @NotBlank
    @Size(min = 3, max = 100, message = "The name must have at least 3 letters and max of 100!")
    private String name;

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "invalid!")
    private String cpf;

    @Email
    @NotBlank(message = "email cannot be blank!")
    private String email;

    @NotBlank(message = "you must insert a phone number!")
    private String phoneNumber;
}
