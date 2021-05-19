package example.micronaut

import io.reactivex.Flowable

interface FileOperations {
    fun findAll(): Flowable<Book>
}
