package example.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class FilesControllerTest {
    @Inject
    @field:Client("/")
    lateinit var rxHttpClient: RxHttpClient

    @Test
    fun testFilesController() {
        val rsp = rxHttpClient.toBlocking().exchange(HttpRequest.GET<Any>("/files/stock/1491950358"), Boolean::class.java)
        Assertions.assertEquals(rsp.status(), HttpStatus.OK)
        Assertions.assertTrue(rsp.body()!!)
    }

    @Test
    fun testFilesControllerWithNonExistingIsbn() {
        val thrown = Assertions.assertThrows(HttpClientResponseException::class.java) { rxHttpClient.toBlocking().exchange(HttpRequest.GET<Any>("/files/stock/XXXXX"), Boolean::class.java) }
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                thrown.response.status
        )
    }
}