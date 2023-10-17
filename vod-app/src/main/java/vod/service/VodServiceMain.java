package vod.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.config.VodConfig;
import vod.model.Movie;
import vod.model.Rating;
import vod.model.Cinema;

import java.util.List;

@Slf4j
public class VodServiceMain {

    public static void main(String[] args) throws ClassNotFoundException {
        log.info("Let's find cinemas!");
        Class.forName("vod.repository.mem.SampleData");

        // service preparation
        ApplicationContext context = new AnnotationConfigApplicationContext(VodConfig.class);

        CinemaService service = context.getBean(CinemaService.class);
        MovieService movieService = context.getBean(MovieService.class);

        // service use
        List<Cinema> cinemas = service.getAllCinemas();
        log.info(cinemas.size() + " cinemas found:");
        cinemas.forEach(System.out::println);

        Movie movie = movieService.getMovieById(2);
        List<Rating> ratings = movieService.getRatingsByMovie(movie);
        log.info("Rating of movie {}", movie.getTitle());
        ratings.forEach(rating -> log.info("rate: {}", rating.getRate()));



    }
}
