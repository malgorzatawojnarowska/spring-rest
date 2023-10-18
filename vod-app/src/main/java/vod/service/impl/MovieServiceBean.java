package vod.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Rating;
import vod.repository.CinemaDao;
import vod.repository.DirectorDao;
import vod.repository.MovieDao;
import vod.model.Cinema;
import vod.model.Director;
import vod.model.Movie;
import vod.repository.RatingDao;
import vod.service.MovieService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceBean implements MovieService {

    private final DirectorDao directorDao;
    private final CinemaDao cinemaDao;
    private final MovieDao movieDao;
    private final RatingDao ratingDao;

    public List<Movie> getAllMovies() {
        log.info("searching all movies...");
        return movieDao.findAll();
    }

    public List<Movie> getMoviesByDirector(Director d) {
        log.info("serching movies by diretor " + d.getId());
        return movieDao.findByDirector(d);
    }

    public List<Movie> getMoviesInCinema(Cinema c) {
        log.info("searching movies played in cinema " + c.getId());
        return movieDao.findByCinema(c);
    }

    public Movie getMovieById(int id) {
        log.info("searching movie by id " + id);
        return movieDao.findById(id).orElse(null);
    }

    public List<Cinema> getAllCinemas() {
        log.info("searching all cinemas");
        return cinemaDao.findAll();
    }

    public List<Cinema> getCinemasByMovie(Movie m) {
        log.info("searching cinemas by movie " + m.getId());
        return cinemaDao.findByMovie(m);
    }

    public Cinema getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return cinemaDao.findById(id).orElse(null);
    }

    public List<Director> getAllDirectors() {
        log.info("searching all directors");
        return directorDao.findAll();
    }

    public Director getDirectorById(int id) {
        log.info("searching director by id " + id);
        return directorDao.findById(id).orElse(null);
    }

    @Override
    public Movie addMovie(Movie m) {
        log.info("about to add movie " + m);
        return movieDao.save(m);
    }

    @Override
    public Rating rateMovie(Movie m, float rate) {
        Rating rating = new Rating();
        rating.setRate(rate);
        rating.setMovie(m);
        return ratingDao.save(rating);
    }

    @Override
    public List<Rating> getRatingsByMovie(Movie movie) {
        return ratingDao.findAllByMovie(movie);
    }

    @Override
    public Director addDirector(Director d) {
        log.info("about to add director " + d);
        return directorDao.save(d);
    }

}
