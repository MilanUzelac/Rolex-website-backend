package userservice.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_credentials")
public class UserCredentials {
    @Id
    private int userId;
    private ROLE role;
    private String userName;
    private String password;

    public UserCredentials(int userId, ROLE role, String userName, String password) {
        this.userId = userId;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public UserCredentials() {
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
