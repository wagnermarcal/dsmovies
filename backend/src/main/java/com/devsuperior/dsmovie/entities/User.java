package com.devsuperior.dsmovie.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String email;

}
