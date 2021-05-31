package userservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import userservice.Model.UserCredentials;

@Repository
public interface UserCredentialsRepository extends MongoRepository<UserCredentials,Integer> {
}
