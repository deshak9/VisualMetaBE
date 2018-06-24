package com.visual

class PostController extends AbstractController {

    /**
     * Will return all Posts belongs to current loggedin user
     * @return
     */
    def index() {
        def u = session.user
        if (u) {
            def posts = Post.findAllByUserId(u.id)
            renderSuccess(posts.collect {
                [title: it.title, content: it.content, createDate: it.createDate, id: it.id]
            })
        } else {
            unauthorizedAccess()
        }
    }

    /**
     * Save newly created post of current use
     * @return
     */
    def save() {
        def req = request.JSON
        def u = session.user

        if (u) {
            def p = new Post(userId: u.id, title: req.title, content: req.content, createDate: req.createDate)
            if (!p.save()) {
                renderError("Something went wrong")
            } else {
                renderSuccess("Saved")
            }
        } else {
            unauthorizedAccess()
        }
    }

    def delete() {
        def postId = params.id
        def u = session.user
        if (u) {
            def p = Post.findByUserIdAndId(u.id, postId)
            println(u)
            println(p)
            if (!p) {
                renderError("Post not found")
            } else {
                p.delete()
                renderSuccess("Post Deleted")
            }
        } else {
            unauthorizedAccess()
        }
    }
}


