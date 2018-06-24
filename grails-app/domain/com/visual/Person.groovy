package com.visual

import grails.persistence.Entity
import org.grails.plugins.codecs.HexCodec
import org.grails.plugins.codecs.SHA256BytesCodec

@Entity
class Person {

    transient springSecurityService

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    def beforeInsert() {
        password = encodePassword(password)
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            password = encodePassword(password)
        }
    }

    def validatePassword(password) {
        return this.password == encodePassword(password)
    }

    protected String encodePassword(String password) {
        def hash = HexCodec.encode(SHA256BytesCodec.encode(password + username + "salft value afsafjsaklfjsaflksajflksajfsafbasjfbasjfsbakfsabfjkasfbkjasbf"))
        return hash
    }
}
