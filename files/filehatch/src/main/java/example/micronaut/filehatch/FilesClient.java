package example.micronaut.filehatch;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;
import io.reactivex.Flowable;

@Client("http://localhost:8081")
@Recoverable(api = FilesOperations.class)
interface FilesClient extends FilesOperations {

    @Get("/files")
    Flowable<File> findAll();
}