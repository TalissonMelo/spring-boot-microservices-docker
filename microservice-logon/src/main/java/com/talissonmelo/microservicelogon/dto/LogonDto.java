package com.talissonmelo.microservicelogon.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LogonDto {
    private String email;
    private String password;
}
