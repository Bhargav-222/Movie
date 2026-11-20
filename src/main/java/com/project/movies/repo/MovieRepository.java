package com.project.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.movies.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}
