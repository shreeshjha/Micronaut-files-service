package example.micronaut.filehatch;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;

import javax.inject.Singleton;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class FileClientStub implements FilesOperations {

    @Override
    public Flowable<File> findAll() {
        File buildingMicroservices = new File("1491950358", "Creating Microservices");
        File releaseIt = new File("1680502395", "Publish It!");
        return Flowable.just(buildingMicroservices, releaseIt);
    }
}