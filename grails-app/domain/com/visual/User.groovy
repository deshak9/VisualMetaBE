package com.visual

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import grails.persistence.Entity

@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
class User extends Person {
    String firstName
    String lastName
}