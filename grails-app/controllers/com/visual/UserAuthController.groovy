package com.visual

class UserAuthController extends AbstractController {

    def login() {
        def req = request.JSON

        // Find user by username in the database
        User u = User.findByUsername(req.username)

        if (u) {

            // Validate the password
            if (u.validatePassword(req.password)) {

                // As user's username and password is correct, store user in the session
                session.user = u
                renderSuccess([firstName: u.firstName, lastName: u.lastName, username: u.username])
            } else {
                renderError("Username or password incorrect")
            }
        } else {
            renderError("Username ${req.username} doesn't exist")
        }
    }

    def registerUser() {
        def req = request.JSON
        def sessionUser = session.user
        if (sessionUser) {
            renderError("Logged in user can not create account")
        } else if (User.list().find { req.username == it.username }) { // Search if username already exist
            renderError("Username already exist")
        } else {
            def u = new User(firstName: req.firstName, lastName: req.lastName, username: req.username, password: req.password)

            // Trying to save the new user
            if (!u.save()) {
                renderError()
            } else {
                session.user = u

                // Return only relevant info to UI
                renderSuccess([firstName: u.firstName, lastName: u.lastName, username: u.username])
            }
        }

    }

    def logout() {
        // remove user session on logout
        session.user = null
        renderSuccess("User logged out")
    }
}


