package userservice.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userservice_admin")
public class UserAdmin {
        @Id
        private String userName;

        public UserAdmin(){}

        public UserAdmin(String userName) {
            this.userName = userName;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }

}
