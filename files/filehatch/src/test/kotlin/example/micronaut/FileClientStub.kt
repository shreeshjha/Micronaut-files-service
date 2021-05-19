package example.micronaut

import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable

import javax.inject.Singleton

@Requires(env = arrayOf(Environment.TEST))
@Fallback
@Singleton
class FileClientStub : FileOperations {

    override fun findAll(): Flowable<File> {
        val buildingMicroservices = File("1491950358", "Creating services")
        val releaseIt = File("1680502395", "Publishing It!")
        return Flowable.just(buildingMicroservices, releaseIt)
    }
}
