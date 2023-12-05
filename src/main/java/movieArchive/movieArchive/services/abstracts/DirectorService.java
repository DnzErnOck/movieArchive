package movieArchive.movieArchive.services.abstracts;

import movieArchive.movieArchive.services.dtos.requests.director.AddDirectorRequest;
import movieArchive.movieArchive.services.dtos.requests.director.UpdateDirectorRequest;
import movieArchive.movieArchive.services.dtos.responses.director.GetDirectorResponse;
import movieArchive.movieArchive.services.dtos.responses.director.GetListDirectorResponse;

import java.util.List;

public interface DirectorService {
    List<GetListDirectorResponse> getAll();
    GetDirectorResponse getById(int id);
    void add(AddDirectorRequest addDirectorRequest);
    void update(UpdateDirectorRequest updateDirectorRequest,int id);
    void delete(int id);
}
