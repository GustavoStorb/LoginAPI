package com.gustavostorb.auth.user.dto;

import com.gustavostorb.auth.user.model.User;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString()
@Data
public class UpdateUserDTO {

    private String user;
    private String email;
    private String password;
    @NotNull(message = "Confirm password is required")
    private String confirmPassword;

    public void updateUser(User user) {
        if(this.user != null) {
            user.setUser(this.user);
        }

        if(this.email != null) {
            user.setEmail(this.email);
        }

        if(this.password != null) {
            user.setPassword(this.password);
        }

    }
}
