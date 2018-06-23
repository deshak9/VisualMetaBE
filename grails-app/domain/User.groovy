import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import grails.persistence.Entity

@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
class User {
    String firstName
    String lastName
    String userName
    String hashedPassword
    String token
}