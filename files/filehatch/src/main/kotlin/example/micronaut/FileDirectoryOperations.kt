package example.micronaut

import io.reactivex.Maybe

import javax.validation.constraints.NotBlank

interface FileDirectoryOperations {
    fun stock(@NotBlank isbn: String): Maybe<Boolean>
}
