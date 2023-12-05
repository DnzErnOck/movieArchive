package movieArchive.movieArchive.repositories;

import movieArchive.movieArchive.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Integer> {
}
