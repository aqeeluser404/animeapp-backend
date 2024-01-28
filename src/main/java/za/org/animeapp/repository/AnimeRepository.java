package za.org.animeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.org.animeapp.domain.Anime;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    public List<Anime> findAllByGenre(String genre);
}
