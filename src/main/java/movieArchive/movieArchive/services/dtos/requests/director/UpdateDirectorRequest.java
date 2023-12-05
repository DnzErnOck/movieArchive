package movieArchive.movieArchive.services.dtos.requests.director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDirectorRequest {
    private String firstName;
    private String lastName;
}
