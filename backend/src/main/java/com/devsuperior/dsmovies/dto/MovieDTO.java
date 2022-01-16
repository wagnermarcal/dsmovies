package com.devsuperior.dsmovies.dto;

import com.devsuperior.dsmovies.entities.Movie;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieDTO {
    private Long id;

    private String title;

    private Double score;

    private Integer count;

    private String image;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.score = movie.getScore();
        this.count = movie.getCount();
        this.image = movie.getImage();
    }
}
