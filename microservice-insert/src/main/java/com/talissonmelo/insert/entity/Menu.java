package com.talissonmelo.insert.entity;

import com.talissonmelo.insert.dto.MenuDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Data
@Table(name = "tb_menu")
public class Menu {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public static Menu createMenu(MenuDto menuDto){
        return new ModelMapper().map(menuDto, Menu.class);
    }
}
