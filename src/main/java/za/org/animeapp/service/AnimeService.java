package za.org.animeapp.service;

import za.org.animeapp.domain.Anime;

import java.util.List;

public interface AnimeService extends IService <Anime, Integer> {
    List<Anime> getAll();
}
