package vod.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Cinema;
import vod.model.Movie;
import vod.service.MovieService;
import vod.web.dto.MovieDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    List<MovieDTO> getMovies(){
        log.info("about to retrieve movies");
        List<Movie> movies = movieService.getAllMovies();
        log.info("found {} movies", movies.size());
        return movies.stream()
                .map(MovieDTO::fromData)
                .toList();
    }

    @GetMapping("/movies/{movieId}")
    ResponseEntity<MovieDTO> getMovie(@PathVariable("movieId") int movieId){
        log.info("about to retrieve movie {}", movieId);
        Movie movie = movieService.getMovieById(movieId);
        if(movie!=null)
            return ResponseEntity.status(HttpStatus.OK).body(MovieDTO.fromData(movie));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/movies")
    ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        log.info("about to add new movie {}", movieDTO);
        Movie movie = movieService.addMovie(movieDTO.toData());

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(movie.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(MovieDTO.fromData(movie));
    }

}
