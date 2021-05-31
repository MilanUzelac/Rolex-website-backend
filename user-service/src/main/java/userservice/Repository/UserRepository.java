package userservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import userservice.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    User findUserByUserName(String username);
}
