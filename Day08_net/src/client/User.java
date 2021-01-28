package client;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6732775730366283601L;
    private String username;
    private String passward;

    public User() {
    }

    public User(String username, String passward) {
        this.username = username;
        this.passward = passward;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
