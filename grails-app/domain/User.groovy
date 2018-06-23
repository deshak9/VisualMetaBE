import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import grails.persistence.Entity

@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
class User {
    String firstName
    String lastName
}