import grails.converters.JSON

import javax.servlet.http.HttpServletResponse

class UserController {

    def index() {
//        def springSecurityService

//        if (springSecurityService.isLoggedIn()) {
            render User.list() as JSON
//        } else {
//            response.sendError HttpServletResponse.SC_UNAUTHORIZED
//        }
    }

    def save() {
        def p1 = new User(firstName: "Fred", lastName: "ojha", userName: 'asf', hashedPassword: 'safsaf', token: 'asfsa')
        p1.save()
        render "success"
    }

    def delete() {
        render "success"
    }
}


