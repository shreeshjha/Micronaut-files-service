package example.micronaut.filehatch;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

@Controller("/files")
public class FileController {

    private final FilesOperations filesOperations;
    private final FileDirectoryOperations fileDirectoryOperations;

    public FileController(FilesOperations filesOperations,
                          FileDirectoryOperations fileDirectoryOperations) {
        this.filesOperations = filesOperations;
        this.fileDirectoryOperations = fileDirectoryOperations;
    }

    @Get
    public Flowable<FileHatch> index() {
        return filesOperations.findAll()
                .flatMapMaybe(b -> fileDirectoryOperations.stock(b.getIsbn())
                        .filter(Boolean::booleanValue)
                        .map(rsp -> b)
                ).map(file -> new FileHatch(file.getName()));
    }
}