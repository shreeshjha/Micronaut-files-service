package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/files") // <1>
class FilesController {

    @Get // <2>
    internal fun index(): List<File> {
        return listOf(File("1491950358", "Creating services"),
                File("1680502395", "Publishing It!"),
                File("0321601912", "Delivering :"))
    }
}
