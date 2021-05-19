package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import java.util.Optional
import javax.validation.constraints.NotBlank

@Controller("/files") // <1>
open class FilesController {

    @Produces(MediaType.TEXT_PLAIN) // <2>
    @Get("/stock/{isbn}") // <3>
    open fun stock(@NotBlank isbn: String): Boolean? {
        return fileDirectoryByIsbn(isbn).map { (_, stock) -> stock > 0 }.orElse(null)
    }

    private fun fileDirectoryByIsbn(isbn: String): Optional<FileDirectory> {
        if (isbn == "1491950358") {
            return Optional.of(FileDirectory(isbn, 4))

        } else if (isbn == "1680502395") {
            return Optional.of(FileDirectory(isbn, 0))
        }
        return Optional.empty()
    }
}
