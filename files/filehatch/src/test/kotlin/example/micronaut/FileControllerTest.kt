package example.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxStreamingHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class FileControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: RxStreamingHttpClient

    @Test
    fun testRetrieveFiles() {
        val files = client.jsonStream(HttpRequest.GET<Any>("/files"), FileHatch::class.java)
        Assertions.assertEquals(files.toList().blockingGet().size, 1)
        Assertions.assertEquals(files.toList().blockingGet()[0].name, "Creating ervices")
    }
}