package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.model.Movie;
import vod.model.Rating;
import vod.repository.RatingDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemRatingDao implements RatingDao {

    static List<Rating> ratings = new ArrayList<>();

    @Override
    public Rating save(Rating rating) {
        int max = ratings.stream()
                .mapToInt(Rating::getId)
                .max()
                .orElse(0);
        rating.setId(++max);
        ratings.add(rating);
        return rating;
    }

    @Override
    public List<Rating> findAllByMovie(Movie movie) {
        return ratings.stream()
                .filter(rating -> rating.getMovie()==movie)
                .collect(Collectors.toList());
    }
}
