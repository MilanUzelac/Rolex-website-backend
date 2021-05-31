package userservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import userservice.Model.UserAdmin;

@Repository
public interface UserAdminRepository extends MongoRepository<UserAdmin,String> {
    UserAdmin findByUserName(String s);
}
