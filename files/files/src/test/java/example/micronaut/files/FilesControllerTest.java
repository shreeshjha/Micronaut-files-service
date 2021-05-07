package example.micronaut.files;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class FilesControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testRetrieveFiles() {
        HttpRequest request = HttpRequest.GET("/files");
        List files = client.toBlocking().retrieve(request, Argument.listOf(File.class));
        assertEquals(3, files.size());
        assertTrue(files.contains(new File("1491950358", "Creating Microservices")));
        assertTrue(files.contains(new File("1680502395", "Publishing It!")));
    }
}