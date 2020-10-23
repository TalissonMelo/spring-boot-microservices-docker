package com.talissonmelo.insert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MenuOrderDto {

	private Long idClient;
	private Long idRestaurant;
}
