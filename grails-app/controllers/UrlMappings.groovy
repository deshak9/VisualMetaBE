class UrlMappings {

    static mappings = {

        group "/visualmeta", {
            "/api/login"(controller: "userAuth", parseRequest: true) {
                action = [GET: 'logout', POST: 'login']
            }

            "/api/register"(controller: "userAuth", parseRequest: true) {
                action = [POST: 'registerUser']
            }

            "/api/logout"(controller: "userAuth", parseRequest: true) {
                action = [POST: 'logout']
            }

            "/api/posts"(controller: "post", parseRequest: true) {
                action = [GET: "index", POST: 'save', PUT: "update", DELETE: "delete"]
            }

            "/api/posts/$id"(controller: "post", parseRequest: true) {
                action = [DELETE: "delete"]
            }
        }

        "/"(redirect: "/visualmeta/ui/")
        "/visualmeta"(redirect: "/visualmeta/ui/")
        "/visualmeta/ui"(controller: "appRender")
        "/visualmeta/ui/**"(controller: "appRender")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
