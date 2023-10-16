package vod.service;

import vod.model.Director;
import vod.model.Movie;
import vod.model.Rating;

import java.util.List;

public interface MovieService {


    // movies
    List<Movie> getAllMovies();

    List<Movie> getMoviesByDirector(Director d);

    Movie getMovieById(int id);

    Movie addMovie(Movie m);


    // ratings

    Rating rateMovie(Movie m, float rating);

    List<Rating> getRatingsByMovie(Movie movie);


    // directors

    List<Director> getAllDirectors();

    Director getDirectorById(int id);

    Director addDirector(Director d);
}
