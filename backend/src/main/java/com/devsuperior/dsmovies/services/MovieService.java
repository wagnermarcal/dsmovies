package com.devsuperior.dsmovies.services;

import com.devsuperior.dsmovies.dto.MovieDTO;
import com.devsuperior.dsmovies.entities.Movie;
import com.devsuperior.dsmovies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        Page<MovieDTO> page = result.map(movie -> new MovieDTO(movie));
        return page;
    }

    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }

}
