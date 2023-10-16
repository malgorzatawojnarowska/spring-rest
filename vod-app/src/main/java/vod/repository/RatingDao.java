package vod.repository;

import vod.model.Movie;
import vod.model.Rating;

import java.util.List;

public interface RatingDao {

    Rating save(Rating rating);

    List<Rating> findAllByMovie(Movie movie);

}
