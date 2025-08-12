package academy.devdojo.springboot2_essentials.service;

import academy.devdojo.springboot2_essentials.domain.Anime;
import academy.devdojo.springboot2_essentials.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService implements AnimeRepository {
    // private final AnimeRepository animeRepository
    public List<Anime> listAll() {
        return List.of(new Anime(1L,"Boku no Hero"), new Anime(2L,"Berzerker"));
    }
}
