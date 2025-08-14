package academy.devdojo.springboot2_essentials.requests;

import lombok.Data;

@Data
public class AnimePutRequestBody {
    private long id;
    private String name;
}
