package academy.devdojo.springboot2_essentials.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be empty")
   // @NotNull(message ="The anime name cannot be empty" )
    private String name;
    private String url;
}
