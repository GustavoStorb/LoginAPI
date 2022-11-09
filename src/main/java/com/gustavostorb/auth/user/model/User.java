package com.gustavostorb.auth.user.model;

import com.gustavostorb.auth.user.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@Getter @Setter
@Data @RequiredArgsConstructor
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String email;
    private String password;
    private UserType type;

    public User(String user, String email, String password, UserType type) {
        this.user = user;
        this.email = email;
        this.password = password;
        this.type = type;
    }
}
