package com.gustavostorb.auth.user.dto;

import com.gustavostorb.auth.user.enums.UserType;
import com.gustavostorb.auth.user.model.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString()
@Data
public class CreateUserDTO {

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String user;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    public User toUser() {
        return new User(
                this.user,
                this.email,
                this.password,
                UserType.USER
        );
    }
}
