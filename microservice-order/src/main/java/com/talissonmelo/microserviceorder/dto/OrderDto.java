package com.talissonmelo.microserviceorder.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class OrderDto {

    private Long id;
    private Long idClient;
    private Long idRestaurant;
    private Long idMenu;

}
