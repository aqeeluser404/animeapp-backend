package za.org.animeapp.factory;

import org.springframework.stereotype.Component;
import za.org.animeapp.domain.Anime;
import za.org.animeapp.util.Helper;

@Component
public class AnimeFactory {
    public static Anime createAnime(String title, String genre, int episodeCount, String status, double rating) {

        if (Helper.isNullOrEmpty(title) || (Helper.isNullOrEmpty(status))) {
            return null;
        }

//        int generateId = Helper.generateId();

        return new Anime.Builder()
//                .setId(generateId)
                .setTitle(title)
                .setGenre(genre)
                .setEpisodeCount(episodeCount)
                .setStatus(status)
                .setRating(rating)
                .build();
    }

    public static Anime animeCreated(int id, String title, String genre, int episodeCount, String status, double rating) {

        if (Helper.isNullOrEmpty(title) || (Helper.isNullOrEmpty(status))) {
            return null;
        }

        return new Anime.Builder()
                .setId(id)
                .setTitle(title)
                .setGenre(genre)
                .setEpisodeCount(episodeCount)
                .setStatus(status)
                .setRating(rating)
                .build();
    }

    public Anime create() {
        return Anime.builder().build();
    }

    public Anime create(Anime anime) {
        return Anime.builder().copy(anime).build();
    }
}
