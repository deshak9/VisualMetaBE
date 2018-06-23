class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        /*"authenticate"(controller: "login", parseRequest: true) {
            action = [POST: 'login']
        }*/

        "/api/users"(controller: "user", parseRequest: true) {
            action = [GET: "index", POST: 'save', PUT: "update", DELETE: "delete"]
        }

        "/api/posts"(controller: "post", parseRequest: true) {
            action = [GET: "index", POST: 'save', PUT: "update", DELETE: "delete"]
        }


        "/api/test"(controller: "test", parseRequest: true) {
            action = [GET: "show"]
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
