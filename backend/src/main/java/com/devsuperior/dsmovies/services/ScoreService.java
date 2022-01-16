package com.devsuperior.dsmovies.services;

import com.devsuperior.dsmovies.dto.MovieDTO;
import com.devsuperior.dsmovies.dto.ScoreDTO;
import com.devsuperior.dsmovies.entities.Movie;
import com.devsuperior.dsmovies.entities.Score;
import com.devsuperior.dsmovies.entities.User;
import com.devsuperior.dsmovies.repositories.MovieRepository;
import com.devsuperior.dsmovies.repositories.ScoreRepository;
import com.devsuperior.dsmovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(MovieRepository movieRepository, UserRepository userRepository, ScoreRepository scoreRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }
        movie.setScore(sum / movie.getScores().size());
        movie.setCount(movie.getScores().size());

        movie = movieRepository.saveAndFlush(movie);

        return new MovieDTO(movie);
    }


}
