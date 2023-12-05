package movieArchive.movieArchive.services.concretes;

import lombok.AllArgsConstructor;
import movieArchive.movieArchive.entities.Director;
import movieArchive.movieArchive.repositories.DirectorRepository;
import movieArchive.movieArchive.services.abstracts.DirectorService;
import movieArchive.movieArchive.services.dtos.requests.director.AddDirectorRequest;
import movieArchive.movieArchive.services.dtos.requests.director.UpdateDirectorRequest;
import movieArchive.movieArchive.services.dtos.responses.director.GetDirectorResponse;
import movieArchive.movieArchive.services.dtos.responses.director.GetListDirectorResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DirectorManager implements DirectorService {
    private final DirectorRepository directorRepository;


    @Override
    public List<GetListDirectorResponse> getAll() {
        List<Director> directorList = directorRepository.findAll();
        List<GetListDirectorResponse> getListDirectorResponseList = new ArrayList<>();
        for (Director director : directorList){
            GetListDirectorResponse response = new GetListDirectorResponse();
            response.setFirstName(director.getFirstName());
            response.setLastName(director.getLastName());
            getListDirectorResponseList.add(response);
        }
        return getListDirectorResponseList;
    }

    @Override
    public GetDirectorResponse getById(int id) {
        Director director =directorRepository.findById(id).orElseThrow();
        GetDirectorResponse getDirectorResponse =new GetDirectorResponse();
        getDirectorResponse.setId(director.getId());
        getDirectorResponse.setFirstName(director.getFirstName());
        getDirectorResponse.setLastName(director.getLastName());
        return getDirectorResponse;
    }

    @Override
    public void add(AddDirectorRequest addDirectorRequest) {
        Director director  = new Director();
        director.setFirstName(addDirectorRequest.getFirstName());
        director.setLastName(addDirectorRequest.getLastName());
        directorRepository.save(director);
    }

    @Override
    public void update(UpdateDirectorRequest updateDirectorRequest, int id) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isPresent()){
            Director foundDirector= director.get();
            foundDirector.setFirstName(updateDirectorRequest.getFirstName());
            foundDirector.setLastName(updateDirectorRequest.getLastName());
            directorRepository.save(foundDirector);
        }
    }

    @Override
    public void delete(int id) {
        directorRepository.deleteById(id);
    }
}
