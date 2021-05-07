package example.micronaut.filehatch;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;
import io.micronaut.retry.annotation.Recoverable;
import javax.validation.constraints.NotBlank;

@Client("http://localhost:8082")
@Recoverable(api = FileDirectoryOperations.class)
interface FileDirectoryClient extends FileDirectoryOperations {

    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/files/stock/{isbn}")
    Maybe<Boolean> stock(@NonNull @NotBlank String isbn);
}