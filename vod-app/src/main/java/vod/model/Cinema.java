package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Cinema {

    private int id;
    private String name;
    private String logo;
    private List<Movie> movies = new ArrayList<>();

    public Cinema(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public void addMovie(Movie m) {
        this.movies.add(m);
    }

}
