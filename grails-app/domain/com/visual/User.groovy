package com.visual

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import grails.persistence.Entity

/**
 * This class will create the schema in Database when application starts
 */
@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
class User extends Person {
    String firstName
    String lastName
}