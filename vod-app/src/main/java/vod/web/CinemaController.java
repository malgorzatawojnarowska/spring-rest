package vod.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Cinema;
import vod.service.CinemaService;
import vod.web.dto.CinemaDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/cinemas")
    List<CinemaDTO> getCinemas(){
        log.info("about to retrieve cinemas");
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        log.info("found {} cinemas", cinemas.size());

        return cinemas.stream()
                .map(CinemaDTO::fromData)
                .toList();
    }

    @GetMapping("/cinemas/{cinemaId}")
    ResponseEntity<CinemaDTO> getCinema(@PathVariable("cinemaId") int cinemaId){
        log.info("about to retrieve cinema {}", cinemaId);
        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        if(cinema!=null)
            return ResponseEntity.ok(CinemaDTO.fromData(cinema));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
