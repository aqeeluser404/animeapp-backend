package za.org.animeapp.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.org.animeapp.domain.Anime;

class AnimeFactoryTest {

    @Test
    void createAnime() {
        Anime anime = AnimeFactory.createAnime("naruto", "shounen", 500, "completed", 10.0);
        Assertions.assertNotNull(anime);
        System.out.println(anime.toString());
    }
}