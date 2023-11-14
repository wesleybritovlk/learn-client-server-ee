package students;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    private Student() {
    }

    private Student(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}