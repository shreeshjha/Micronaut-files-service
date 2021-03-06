//tag::packageandimports[]
package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Maybe

import javax.validation.constraints.NotBlank

//end::packageandimports[]
/*
//tag::harcoded[]
@Client("http://localhost:8082") // <1>
@Recoverable(api = BookInventoryOperations::class)
//end::harcoded[]
*/
//tag::consul[]
@Client(id = "filedirectory") // <1>
@Recoverable(api = FileDirectoryOperations::class)
//end::consul[]
//tag::clazz[]
interface FileDirectoryClient : FileDirectoryOperations {

    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/files/stock/{isbn}")
    override fun stock(@NotBlank isbn: String): Maybe<Boolean>
}
//end::clazz[]
