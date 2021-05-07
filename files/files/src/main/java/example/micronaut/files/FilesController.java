package example.micronaut.files;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.List;

@Controller("/files")
public final class FilesController {

    @Get
    public List<File> index() {
        File buildingMicroservices = new File("1491950358", "Creeating Microservices");
        File releaseIt = new File("1680502395", "Release It!");
        File cidelivery = new File("0321601912", "Service Delivery:");
        return Arrays.asList(buildingMicroservices, releaseIt, cidelivery);
    }
}