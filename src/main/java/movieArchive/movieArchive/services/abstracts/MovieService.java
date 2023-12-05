package movieArchive.movieArchive.services.abstracts;

import movieArchive.movieArchive.entities.Movie;
import movieArchive.movieArchive.services.dtos.requests.movie.AddMovieRequest;
import movieArchive.movieArchive.services.dtos.requests.movie.UpdateMovieRequest;
import movieArchive.movieArchive.services.dtos.responses.movie.GetListMovieResponse;
import movieArchive.movieArchive.services.dtos.responses.movie.GetMovieResponse;

import java.util.List;

public interface MovieService {
    List<GetListMovieResponse> getAll();
    GetMovieResponse getById(int id);
    void add(AddMovieRequest addMovieRequest);
    void update(UpdateMovieRequest updateMovieRequest,int id);
    void delete(int id);
    List<GetListMovieResponse> findByPrice(int price);

}
