import grails.converters.JSON
import org.springframework.http.HttpStatus

abstract class AbstractController {

    def renderBadRequest(msg = "Something went wrong") {
        response.status = HttpStatus.BAD_REQUEST.value()
        render new StatusRes(status: "error",
                description: msg,
                statusCode: HttpStatus.BAD_REQUEST.value()) as JSON
    }
}
