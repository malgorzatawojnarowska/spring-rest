package vod.web.dto;

import lombok.Data;
import vod.model.Cinema;

@Data
public class CinemaDTO{
    private int id;
    private String name;
    private String logo;

    public static CinemaDTO fromData(Cinema cinema){
        CinemaDTO dto = new CinemaDTO();
        dto.setId(cinema.getId());
        dto.setName(cinema.getName());
        dto.setLogo(cinema.getLogo());
        return dto;
    }
}