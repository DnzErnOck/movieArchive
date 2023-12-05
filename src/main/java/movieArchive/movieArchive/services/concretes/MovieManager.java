package movieArchive.movieArchive.services.concretes;

import lombok.AllArgsConstructor;
import movieArchive.movieArchive.entities.Movie;
import movieArchive.movieArchive.repositories.MovieRepository;
import movieArchive.movieArchive.services.abstracts.MovieService;
import movieArchive.movieArchive.services.dtos.requests.movie.AddMovieRequest;
import movieArchive.movieArchive.services.dtos.requests.movie.UpdateMovieRequest;
import movieArchive.movieArchive.services.dtos.responses.director.GetListDirectorResponse;
import movieArchive.movieArchive.services.dtos.responses.movie.GetListMovieResponse;
import movieArchive.movieArchive.services.dtos.responses.movie.GetMovieResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieManager implements MovieService {

    private final MovieRepository movieRepository;
    @Override
    public List<GetListMovieResponse> getAll() {

        List<Movie> movieList = movieRepository.findAll();
        List<GetListMovieResponse> getListMovieResponseList = new ArrayList<>();
        for (Movie movie : movieList){
            GetListMovieResponse response = new GetListMovieResponse();
            response.setName(movie.getName());
            getListMovieResponseList.add(response);
        }
        return getListMovieResponseList;
        
    }

    @Override
    public GetMovieResponse getById(int id) {
        Movie movie =movieRepository.findById(id).orElseThrow();
        GetMovieResponse getMovieResponse =new GetMovieResponse();
        getMovieResponse.setId(movie.getId());
        getMovieResponse.setName(movie.getName());
        return getMovieResponse;
    }

    @Override
    public void add(AddMovieRequest addMovieRequest) {
        Movie movie  = new Movie();
        movie.setName(addMovieRequest.getName());
        movieRepository.save(movie);
    }

    @Override
    public void update(UpdateMovieRequest updateMovieRequest, int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()){
            Movie foundMovie= movie.get();
            foundMovie.setName(updateMovieRequest.getName());
            movieRepository.save(foundMovie);
        }
    }

    @Override
    public void delete(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<GetListMovieResponse> findByPrice(int price) {
        List<Movie> movieList=movieRepository.findByPriceGreaterThanEqual(price);
        List<GetListMovieResponse> getListMovieResponseList=new ArrayList<>();
        for (Movie movie:movieList){
            GetListMovieResponse response=new GetListMovieResponse();
            GetListDirectorResponse getListDirectorResponse=new GetListDirectorResponse(movie.getDirector().getFirstName(),movie.getDirector().getLastName());
            response.setName(movie.getName());
            response.setPrice(movie.getPrice());
            response.setDirector(getListDirectorResponse);
            getListMovieResponseList.add(response);
        }
        return getListMovieResponseList;

    }
}
