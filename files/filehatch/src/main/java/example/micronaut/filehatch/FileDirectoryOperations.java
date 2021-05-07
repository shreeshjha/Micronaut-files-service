package example.micronaut.filehatch;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.reactivex.Maybe;
import javax.validation.constraints.NotBlank;

public interface FileDirectoryOperations {
    Maybe<Boolean> stock(@NonNull @NotBlank String isbn);
}