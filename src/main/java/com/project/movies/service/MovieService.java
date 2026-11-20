package com.project.movies.service;

import java.util.List;
import com.project.movies.model.Movie;

public interface MovieService {
    public abstract Movie createMovie(Movie movie);

    public abstract List<Movie> getAllMovies();

    public abstract Movie getMovie(Long id);

    public abstract Movie updateMovie(Movie movie, Long id);

    public abstract void deleteMovie(Long id);

    public abstract Movie findMovieByTitle(String title);
}
