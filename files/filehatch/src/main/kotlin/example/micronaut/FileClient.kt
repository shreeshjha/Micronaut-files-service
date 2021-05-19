//tag::packageandimports[]
package example.micronaut

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Flowable

//end::packageandimports[]
/*
//tag::harcoded[]
@Client("http://localhost:8081") // <1>
@Recoverable(api = BookCatalogueOperations::class)
//end::harcoded[]
*/
//tag::consul[]
@Client(id = "files") // <1>
@Recoverable(api = FileOperations::class)
//end::consul[]
//tag::clazz[]
interface FileClient : FileOperations {

    @Get("/files")
    override fun findAll(): Flowable<File>
}
//end::clazz[]
