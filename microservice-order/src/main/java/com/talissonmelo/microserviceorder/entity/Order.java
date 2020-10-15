package com.talissonmelo.microserviceorder.entity;

import com.talissonmelo.microserviceorder.dto.OrderDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "tb_order")
public class Order {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idClient;
    private Long idRestaurant;
    private Long idMenu;

    public static Order createOrder(OrderDto orderDto){
        return new ModelMapper().map(orderDto, Order.class);
    }
}
