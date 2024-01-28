package za.org.animeapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private int episodeCount;
    private String status;
    private double rating;

    public Anime() {
    }

    private Anime(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.genre = builder.genre;
        this.episodeCount = builder.episodeCount;
        this.status = builder.status;
        this.rating = builder.rating;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public String getStatus() {
        return status;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return id == anime.id && episodeCount == anime.episodeCount && Double.compare(anime.rating, rating) == 0 && Objects.equals(title, anime.title) && Objects.equals(genre, anime.genre) && Objects.equals(status, anime.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, episodeCount, status, rating);
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", episodeCount=" + episodeCount +
                ", status='" + status + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static class Builder {
        private int id;
        private String title;
        private String genre;
        private int episodeCount;
        private String status;
        private double rating;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setEpisodeCount(int episodeCount) {
            this.episodeCount = episodeCount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(Anime anime) {
            this.id = anime.id;
            this.title = anime.title;
            this.genre = anime.genre;
            this.episodeCount = anime.episodeCount;
            this.status = anime.status;
            this.rating = anime.rating;
            return this;
        }

        public Anime build() {
            return new Anime(this);
        }
    }
}
