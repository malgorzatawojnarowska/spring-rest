package vod.model;

import lombok.Data;

@Data
public class Rating {

    private int id;
    private Movie movie;
    private float rate;

    public static Rating of(Movie movie, float value){
        Rating rating = new Rating();
        rating.setMovie(movie);
        rating.setRate(value);
        return rating;
    }

}
