package movieArchive.movieArchive.services.dtos.requests.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
    private String name;
}
