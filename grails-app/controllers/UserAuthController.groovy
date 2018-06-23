import javax.servlet.http.HttpServletResponse

class UserAuthController extends AbstractController {

    def authenticateUser() {
        def req = request.JSON
        User u = User.findByUsername(req.username)
        print(u)
        print(req.username)
        if (u.validatePassword(req.password)) {
            
        } else {
            renderBadRequest("User doesn't exist")
        }
    }

    def registerUser() {
        def req = request.JSON
        def sessionUser = session.user
        print(sessionUser)
        print(User.list().find { req.username == it.username })
        if (sessionUser) {
            renderBadRequest("Logged in user can not create account")
        } else if (User.list().find { req.username == it.username }) {
            renderBadRequest("User name already exist")
        } else {
            def u = new User(firstName: req.firstName, lastName: req.lastName, username: req.username, password: req.password)
            if (!u.save()) {
                renderBadRequest()
            } else {
                session.user = u
                render HttpServletResponse.SC_OK
            }
        }

    }
}


