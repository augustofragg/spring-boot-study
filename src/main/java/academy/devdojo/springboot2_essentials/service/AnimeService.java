package academy.devdojo.springboot2_essentials.service;

import academy.devdojo.springboot2_essentials.domain.Anime;
import academy.devdojo.springboot2_essentials.mapper.AnimeMapper;
import academy.devdojo.springboot2_essentials.repository.AnimeRepository;
import academy.devdojo.springboot2_essentials.requests.AnimePostRequestBody;
import academy.devdojo.springboot2_essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService  {
    private final AnimeRepository animeRepository;

    // private final AnimeRepository animeRepository
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
//        Anime animeSave = Anime.builder()
//                .name(animePostRequestBody.getName())
//                .build();

        Anime animeSave = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        return animeRepository.save(animeSave);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrBadRequestException(animePutRequestBody.getId());
//        Anime animeSave = Anime.builder()
//                .id(savedAnime.getId())
//                .name(animePutRequestBody.getName())
//                .build();

        Anime animeSave = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        animeSave.setId(savedAnime.getId());
        animeRepository.save(animeSave);
    }
}
