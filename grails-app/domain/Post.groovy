import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import grails.persistence.Entity

@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
class Post {
    @JsonIgnore
    @JsonProperty("userId")
    String userId
    String title
    String content
    String createdDate
}