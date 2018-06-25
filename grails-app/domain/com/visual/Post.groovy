package com.visual

import grails.persistence.Entity

/**
 * This class will create the schema in Database when application starts
 */
@Entity
class Post {
    String userId
    String title
    String content
    String createDate

    // Increasing the size of content to 2000 chars, by default it's 255 chars
    static mapping = {
        delegate.content column: "content", length: 2000
    }
}