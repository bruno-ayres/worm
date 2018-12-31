package br.com.engineering.worm.web.rest.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View Model object for storing a user's credentials.
 */
public class LoginVM {

    @NotNull
    @Size(min = 1, max = 50)
    private String email;
    
    @NotNull
    @Size(min = ManagedUserVM.PASSWORD_MIN_LENGTH, max = ManagedUserVM.PASSWORD_MAX_LENGTH)
    private String password;

    private Boolean rememberMe;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginVM{" +
            "username='" + getUsername() + '\'' +
            ", rememberMe=" + rememberMe +
            '}';
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String p_email)
    {
        email = p_email;
    }

    public String getUsername()
    {
        return email;
    }

    public void setUsername(String p_username)
    {
        email = p_username;
    }
}
