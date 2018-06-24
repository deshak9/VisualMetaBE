package com.visual

import grails.converters.JSON
import org.springframework.http.HttpStatus

abstract class AbstractController {

    def renderBadRequest(msg = "Something went wrong") {
        response.status = HttpStatus.BAD_REQUEST.value()
        render new StatusRes(error: true,
                description: msg,
                statusCode: HttpStatus.BAD_REQUEST.value()) as JSON
    }

    def renderError(msg = "Something went wrong") {
        response.status = HttpStatus.OK.value()
        render new StatusRes(error: true,
                description: msg,
                statusCode: HttpStatus.OK.value()) as JSON
    }

    def renderSuccess(rsp) {
        response.status = HttpStatus.OK.value()
        render new StatusRes(success: true,
                response: rsp,
                statusCode: HttpStatus.OK.value()) as JSON
    }

    def unauthorizedAccess() {
        response.status = HttpStatus.UNAUTHORIZED.value()
        render new StatusRes(error: true,
                statusCode: HttpStatus.UNAUTHORIZED.value()) as JSON
    }
}
