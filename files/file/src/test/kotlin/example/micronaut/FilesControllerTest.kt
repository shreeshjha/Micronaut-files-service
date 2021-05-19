package example.micronaut

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest // <1>
class FilesControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: HttpClient // <2>

    @Test
    fun testRetrieveFiles() {
        val request: HttpRequest<*> = HttpRequest.GET<Any>("/files") // <3>
        val files: List<*> = client.toBlocking().retrieve(request, Argument.listOf(File::class.java)) // <4>
        Assertions.assertEquals(3, files.size)
        Assertions.assertTrue(files.contains(File("1491950358", "Creating services")))
        Assertions.assertTrue(files.contains(File("1680502395", "Publishing It!")))
    }
}