package movieArchive.movieArchive.services.dtos.responses.director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDirectorResponse {
    private int id;
    private String firstName;
    private String lastName;
}
