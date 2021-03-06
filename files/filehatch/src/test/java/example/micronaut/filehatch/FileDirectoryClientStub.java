package example.micronaut.filehatch;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Maybe;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class FileDirectoryClientStub implements FileDirectoryOperations {

    @Override
    public Maybe<Boolean> stock(@NonNull @NotBlank String isbn) {
        if (isbn.equals("1491950358")) {
            return Maybe.just(Boolean.TRUE);

        } else if (isbn.equals("1680502395")) {
            return Maybe.just(Boolean.FALSE);
        }
        return Maybe.empty();
    }
}