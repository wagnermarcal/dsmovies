package com.devsuperior.dsmovies.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_movie")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String title;

    private Double score;

    private Integer count;

    private String image;
}
