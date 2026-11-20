package com.project.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movies.model.Movie;
import com.project.movies.repo.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepo;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepo.save(movie); // ✅ returns entity with generated id
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Movie getMovie(Long id) {
        Optional<Movie> movie = movieRepo.findById(id);
        return movie.orElse(null);
    }

    @Override
    public Movie updateMovie(Movie movieDetails, Long id) {
        Movie movie = getMovie(id);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setRating(movieDetails.getRating());
            movie.setGenre(movieDetails.getGenre());
            return movieRepo.save(movie);
        }
        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepo.findByTitle(title);
    }
}
