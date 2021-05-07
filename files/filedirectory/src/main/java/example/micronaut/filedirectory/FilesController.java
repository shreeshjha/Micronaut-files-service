package example.micronaut.filedirectory;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Controller("/files")
public class FilesController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/stock/{isbn}")
    public Boolean stock(@NotBlank String isbn) {
        return fileDirectoryByIsbn(isbn).map(bi -> bi.getStock() > 0).orElse(null);
    }

    private Optional<FileDirectory> fileDirectoryByIsbn(String isbn) {
        if (isbn.equals("1491950358")) {
            return Optional.of(new FileDirectory(isbn, 4));

        } else if (isbn.equals("1680502395")) {
            return Optional.of(new FileDirectory(isbn, 0));
        }
        return Optional.empty();
    }
}