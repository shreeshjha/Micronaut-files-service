package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable

@Controller("/files") // <1>
class FileController(private val fileOperations: FileOperations,
                     private val fileDirectoryOperations: FileDirectoryOperations) { // <2>

    @Get // <3>
    fun index(): Flowable<FileHatch> {
        return fileOperations.findAll()
                .flatMapMaybe { b ->
                    fileDirectoryOperations.stock(b.isbn)
                            .filter { hasStock -> hasStock }
                            .map { _ -> b }
                }.map { (_, name) -> FileHatch(name) }
    }
}
