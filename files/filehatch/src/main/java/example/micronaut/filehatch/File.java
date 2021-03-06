package example.micronaut.filehatch;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Introspected
public class File {
    @NonNull
    @NotBlank
    private String isbn;

    @NonNull
    @NotBlank
    private String name;

    public File() {}

    public File(@NonNull @NotBlank String isbn, @NonNull @NotBlank String name) {
        this.isbn = isbn;
        this.name = name;
    }

    @NonNull
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NonNull String isbn) {
        this.isbn = isbn;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (!isbn.equals(file.isbn)) return false;
        return name.equals(file.name);
    }

    @Override
    public int hashCode() {
        int result = isbn.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}