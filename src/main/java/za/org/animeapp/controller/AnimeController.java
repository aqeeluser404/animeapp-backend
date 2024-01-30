package za.org.animeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.org.animeapp.domain.Anime;
import za.org.animeapp.service.impl.AnimeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/anime")
@CrossOrigin("http://localhost:8081/")
public class AnimeController {

    @Autowired
    private AnimeServiceImpl service;

    @PostMapping("/create")
    public Anime create(@RequestBody Anime anime) {
        return service.create(anime);
    }

    @GetMapping("/read/{id}")
    public Anime read(@PathVariable int id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Anime update(@RequestBody Anime anime) {
        return service.update(anime);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    public List<Anime> getAll() {
        return service.getAll();
    }

    @GetMapping("/allByGenre/{genre}")
    public List<Anime> getAllByGenre(@PathVariable String genre) {
        return service.findAllByGenre(genre);
    }
}
