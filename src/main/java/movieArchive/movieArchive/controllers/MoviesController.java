package movieArchive.movieArchive.controllers;

import lombok.AllArgsConstructor;
import movieArchive.movieArchive.services.abstracts.MovieService;
import movieArchive.movieArchive.services.dtos.requests.movie.AddMovieRequest;
import movieArchive.movieArchive.services.dtos.requests.movie.UpdateMovieRequest;
import movieArchive.movieArchive.services.dtos.responses.movie.GetListMovieResponse;
import movieArchive.movieArchive.services.dtos.responses.movie.GetMovieResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@AllArgsConstructor
public class MoviesController {
    private final MovieService movieService;

    @GetMapping
    public List<GetListMovieResponse> getAll(){
        return movieService.getAll();
    }

    @GetMapping("{id}")
    public GetMovieResponse getById(@PathVariable int id){
        return movieService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddMovieRequest addMovieRequest){
        movieService.add(addMovieRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateMovieRequest updateMovieRequest,@PathVariable int id){
        movieService.update(updateMovieRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        movieService.delete(id);
    }
}
