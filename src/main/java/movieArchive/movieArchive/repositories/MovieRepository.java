package movieArchive.movieArchive.repositories;

import movieArchive.movieArchive.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
