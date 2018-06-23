class UserController {

    def index() {
        def txt = ""
        User.list().collect { User p ->
            txt += "$p.firstName $p.lastName".toString()
        }
        render txt
    }

    def save() {
        def p1 = new User(firstName: "Fred", lastName: "ojha")
        p1.save()
    }

    public List<String> user() {
        User.list().collect { User p ->
            "$p.firstName $p.lastName".toString()
        }

        render('heelo')
    }

    def saveUser() {
        def p = new User(name: "Fred", age: 40, lastVisit: new Date())
        p.save()
    }
}


