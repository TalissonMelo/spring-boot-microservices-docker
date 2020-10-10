package com.talissonmelo.insert.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RestaurantDto {
	
    private String name;
    private String email;
    private String password;
}
