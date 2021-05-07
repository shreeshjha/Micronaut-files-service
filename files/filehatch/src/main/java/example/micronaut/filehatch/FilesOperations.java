package example.micronaut.filehatch;

import io.reactivex.Flowable;

public interface FilesOperations {
    Flowable<File> findAll();
}