package movieArchive.movieArchive.services.dtos.responses.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import movieArchive.movieArchive.entities.Director;
import movieArchive.movieArchive.services.dtos.responses.director.GetListDirectorResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListMovieResponse {
    private String name;
    private int price;
    private GetListDirectorResponse director;
}
