package com.talissonmelo.insert.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientDto {
	
    private String name;
    private String email;
    private String password;
}
