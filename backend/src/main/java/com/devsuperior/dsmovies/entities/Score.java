package com.devsuperior.dsmovies.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
@Getter
@Setter
@RequiredArgsConstructor
public class Score {

    @EmbeddedId
    private ScorePK id = new ScorePK();

    private Double value;

    public void setMovie(Movie movie) {
        this.id.setMovie(movie);
    }

    public void setUser(User user) {
        this.id.setUser(user);
    }
}
