package com.devsuperior.dsmovie.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class ScorePK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private com.devsuperior.dsmovie.entities.Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
