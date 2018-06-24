package com.visual

import grails.persistence.Entity

@Entity
class Post {
    String userId
    String title
    String content
    String createDate
    static mapping = {
        delegate.content column: "content", length: 2000
    }
}