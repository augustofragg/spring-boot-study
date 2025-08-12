package academy.devdojo.springboot2_essentials.controller;

import academy.devdojo.springboot2_essentials.domain.Anime;
import academy.devdojo.springboot2_essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
//@AllArgsConstructor
@RequiredArgsConstructor
public class AnimeController {
    //@Autowired
    private final DateUtil dateUtil;


    //localhost:8080/anime/list
    //@RequestMapping(method = RequestMethod.GET, path = "list")
    @GetMapping(path = "list")
    public List<Anime> list(){

        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Boku no Hero"), new Anime("Berzerker"));
    }

    @GetMapping(path = "list2")
    public List<Anime> list2(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Boku no Hero"), new Anime("Berzerker"), new Anime("Naruto"),new Anime("Akira"));
    }


}
