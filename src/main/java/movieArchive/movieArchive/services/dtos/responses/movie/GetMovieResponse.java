package movieArchive.movieArchive.services.dtos.responses.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMovieResponse {
    private int id;
    private String name;
    private int price;
}
