package com.devsuperior.dsmovies.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "id.movie")
    private Set<Score> scores = new HashSet<>();
}
