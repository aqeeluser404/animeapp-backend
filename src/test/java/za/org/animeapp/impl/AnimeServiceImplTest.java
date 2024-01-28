package za.org.animeapp.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.org.animeapp.domain.Anime;
import za.org.animeapp.factory.AnimeFactory;
import za.org.animeapp.service.impl.AnimeServiceImpl;

import java.util.List;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AnimeServiceImplTest {

    @Autowired
    private AnimeServiceImpl service;

    private static Anime anime1 = AnimeFactory.createAnime(
            "Sword Art Online",
            "Sci-Fi",
            24,
            "Completed",
            8.9);

    private static Anime anime2 = AnimeFactory.createAnime(
            "Naruto Shippuden",
            "Adventure",
            500,
            "Completed",
            9.5);

    private static Anime anime3 = AnimeFactory.createAnime(
            "Bleach",
            "Adventure",
            366,
            "Completed",
            10);

    private static Anime anime4 = AnimeFactory.createAnime(
            "Another",
            "Horror",
            12,
            "Completed",
            7.0);

    private static Anime anime5 = AnimeFactory.createAnime(
            "Attack on Titan Season 1",
            "Adventure",
            24,
            "Completed",
            9.8);

    private static Anime testAnime = AnimeFactory.createAnime(
            "test title",
            "test genre",
            1,
            "Completed",
            1.0);

    @Test
    void a_create() {
        Anime created1 = service.create(anime1);
        System.out.println("Created 1: " + created1);
        Assertions.assertNotNull(created1);

        Anime created2 = service.create(anime2);
        System.out.println("Created 2: " + created2);
        Assertions.assertNotNull(created2);

        Anime created3 = service.create(anime3);
        System.out.println("Created 3: " + created3);
        Assertions.assertNotNull(created3);

        Anime created4 = service.create(anime4);
        System.out.println("Created 4: " + created4);
        Assertions.assertNotNull(created4);

        Anime created5 = service.create(anime5);
        System.out.println("Created 5: " + created5);
        Assertions.assertNotNull(created5);

        Anime testCreated = service.create(testAnime);
        System.out.println("Test Created: " + testCreated);
        Assertions.assertNotNull(testCreated);
    }

    @Test
    void b_read() {
        Anime testRead = service.read(testAnime.getId());
        System.out.println("Test Read: " + testRead);
        Assertions.assertNotNull(testRead);
    }

    @Test
    void c_update() {
        Anime updated = new Anime.Builder().copy(testAnime).setTitle("updated...").setGenre("updated...").build();
        service.update(updated);
        Assertions.assertNotSame(updated, testAnime);
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Get all: ");

        List<Anime> animeList = service.getAll();
        for (Anime anime: animeList) {
            System.out.println(anime);
        }
    }

    @Test
    void e_delete() {
        System.out.println(service.read(testAnime.getId()));
        boolean success = service.delete(testAnime.getId());
        Assertions.assertTrue(success);
        System.out.println("Deleted: " + true);
    }

    @Test
    void f_findAllByGenre() {
        final String GENRE = "Adventure";
        System.out.println("show all by Genre: " + GENRE);

        List<Anime> genreList = service.findAllByGenre(GENRE);
        for (Anime anime: genreList) {
            System.out.println(anime);
        }

    }
}