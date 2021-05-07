package example.micronaut.filehatch;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class FileControllerTest {

    @Inject
    @Client("/")
    RxStreamingHttpClient client;

    @Test
    public void testRetrieveFiles() {
        Flowable<FileHatch> files = client.jsonStream(HttpRequest.GET("/files"), FileHatch.class);
        assertEquals(files.toList().blockingGet().size(), 1);
        assertEquals(files.toList().blockingGet().get(0).getName(), "Creating Microservices");
    }
}