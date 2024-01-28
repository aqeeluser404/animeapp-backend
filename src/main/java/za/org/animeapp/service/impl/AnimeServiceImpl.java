package za.org.animeapp.service.impl;

import org.springframework.stereotype.Service;
import za.org.animeapp.domain.Anime;
import za.org.animeapp.repository.AnimeRepository;
import za.org.animeapp.service.AnimeService;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {

    private AnimeRepository repository;

    private AnimeServiceImpl(AnimeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Anime create(Anime anime) {
        return this.repository.save(anime);
    }

    @Override
    public Anime read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Anime update(Anime anime) {
        if (this.repository.existsById(anime.getId())) {
            return this.repository.save(anime);
        }
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        if (this.repository.existsById(integer)) {
            this.repository.deleteById(integer);
            return true;
        }
        return false;
    }

    @Override
    public List<Anime> getAll() {
        return this.repository.findAll();
    }

    public List<Anime> findAllByGenre(String genre) {
        return this.repository.findAllByGenre(genre);
    }
}

