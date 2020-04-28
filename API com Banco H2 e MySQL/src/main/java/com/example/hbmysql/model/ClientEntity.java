package com.example.hbmysql.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author Harvey Braun
 * @version 1.0
 * @since 25/04/2020
 */
@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// JPA - Java Persistence API
@Entity
@Table(name = "cliente")

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "renda")
    private double income;

}

