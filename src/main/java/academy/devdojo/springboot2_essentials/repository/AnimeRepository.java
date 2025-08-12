package academy.devdojo.springboot2_essentials.repository;

import academy.devdojo.springboot2_essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
