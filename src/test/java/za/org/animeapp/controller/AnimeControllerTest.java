package za.org.animeapp.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.org.animeapp.domain.Anime;
import za.org.animeapp.factory.AnimeFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnimeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/api/anime";

    private static Anime animeToCreate = AnimeFactory.animeCreated(7,"Bunny Girl", "Slice of Life", 12, "Completed", 7.0);

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);

        ResponseEntity<Anime> postResponse = restTemplate.postForEntity(url, animeToCreate, Anime.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Anime saved = postResponse.getBody();
        Assertions.assertEquals(animeToCreate.getId(), saved.getId());
        System.out.println("Saved data: " + saved);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + animeToCreate.getId();
        System.out.println("URL: " + url);

        ResponseEntity<Anime> response = restTemplate.getForEntity(url, Anime.class);
        Assertions.assertEquals(animeToCreate.getId(), response.getBody().getId());
        System.out.println(response.getBody());
    }

    @Test
    void d_update() {
        Anime updated = new Anime.Builder()
                .copy(animeToCreate)
                .setTitle("Bunny Girl S1")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);

        ResponseEntity<Anime> response = restTemplate.postForEntity(url, updated, Anime.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + animeToCreate.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void c_getAll() {
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}