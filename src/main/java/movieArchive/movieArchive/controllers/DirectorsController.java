package movieArchive.movieArchive.controllers;

import lombok.AllArgsConstructor;
import movieArchive.movieArchive.services.abstracts.DirectorService;
import movieArchive.movieArchive.services.dtos.requests.director.AddDirectorRequest;
import movieArchive.movieArchive.services.dtos.requests.director.UpdateDirectorRequest;
import movieArchive.movieArchive.services.dtos.responses.director.GetDirectorResponse;
import movieArchive.movieArchive.services.dtos.responses.director.GetListDirectorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/directors")
@AllArgsConstructor
public class DirectorsController {
   private final DirectorService directorService;

   @GetMapping
   public List<GetListDirectorResponse> getAll(){
        return directorService.getAll();
   }

   @GetMapping("{id}")
    public GetDirectorResponse getById(@PathVariable int id){
       return directorService.getById(id);
   }

   @PostMapping
    public void add(@RequestBody AddDirectorRequest addDirectorRequest){
       directorService.add(addDirectorRequest);
   }

   @PutMapping("{id}")
    public void update(@RequestBody UpdateDirectorRequest updateDirectorRequest,@PathVariable int id){
       directorService.update(updateDirectorRequest,id);
   }
   @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       directorService.delete(id);
   }
}
