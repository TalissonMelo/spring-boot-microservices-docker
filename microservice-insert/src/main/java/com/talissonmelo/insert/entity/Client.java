package com.talissonmelo.insert.entity;

import com.talissonmelo.insert.dto.ClientDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Data
@Table(name = "tb_client")
public class Client {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Client createClient(ClientDto clientDto){
        return new ModelMapper().map(clientDto, Client.class);
    }
}
