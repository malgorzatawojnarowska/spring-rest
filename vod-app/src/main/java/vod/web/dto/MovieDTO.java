package vod.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import vod.model.Director;
import vod.model.Movie;

@Data
@NoArgsConstructor
public class MovieDTO{
    private int id;
    private String title;
    private String poster;
    private int directorId;

    public static MovieDTO fromData(Movie movie){
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setPoster(movie.getPoster());
        dto.setDirectorId(movie.getDirector().getId());
        return dto;
    }

    public Movie toData(){
        Movie data = new Movie();
        data.setId(this.id);
        data.setTitle(this.title);
        data.setPoster(this.poster);

        Director director = new Director();
        director.setId(this.directorId);
        data.setDirector(director);

        return data;
    }
}
