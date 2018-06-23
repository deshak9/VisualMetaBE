import grails.converters.JSON

class PostController {

    def index() {
        render Post.list() as JSON
    }

    def save() {
        def p1 = new Post(userId: 'sfsa', title: "Title", content: "content", createdDate: 'today')
        p1.save()
    }
}


