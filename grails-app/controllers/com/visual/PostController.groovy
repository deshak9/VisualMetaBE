package com.visual

class PostController extends AbstractController {

    /**
     * Will return all Posts belongs to current loggedin user
     * @return
     */
    def index() {
        def u = session.user

        // If user session is not valid, raise Unauthorised exception
        if (u) {

            // Will fetch All the posts belongs to current user from the Database
            def posts = Post.findAllByUserId(u.id)

            // Displaying only relevant info, hiding critical field like password
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

        // If user session is not valid, raise Unauthorised exception
        if (u) {
            def p = new Post(userId: u.id, title: req.title, content: req.content, createDate: req.createDate)

            // Trying to save post details in the Database
            if (!p.save()) {
                // Failed to save
                renderError("Something went wrong")
            } else {
                // Successfully saved
                renderSuccess("Saved")
            }
        } else {
            unauthorizedAccess()
        }
    }

    def delete() {
        def postId = params.id
        def u = session.user

        // If user session is not valid, raise Unauthorised exception
        if (u) {

            // Find post by User's id and PostId in the database
            def p = Post.findByUserIdAndId(u.id, postId)

            if (!p) {
                renderError("Post not found")
            } else {

                // Deleting the post in db
                p.delete()
                renderSuccess("Post Deleted")
            }
        } else {
            unauthorizedAccess()
        }
    }
}


