class UserAuthController extends AbstractController {

    def login() {
        def req = request.JSON
        User u = User.findByUsername(req.username)
        if (u) {
            if (u.validatePassword(req.password)) {
                session.user = u
                renderSuccess(u)
            } else {
                renderError("Username or password incorrect")
            }
        } else {
            renderError("User doesn't exist")
        }
    }

    def registerUser() {
        def req = request.JSON
        def sessionUser = session.user
        if (sessionUser) {
            renderError("Logged in user can not create account")
        } else if (User.list().find { req.username == it.username }) {
            renderError("User name already exist")
        } else {
            def u = new User(firstName: req.firstName, lastName: req.lastName, username: req.username, password: req.password)
            if (!u.save()) {
                renderError()
            } else {
                session.user = u
                renderSuccess(u)
            }
        }

    }

    def logout() {
        session.user = null
        renderSuccess("User logged out")
    }
}


