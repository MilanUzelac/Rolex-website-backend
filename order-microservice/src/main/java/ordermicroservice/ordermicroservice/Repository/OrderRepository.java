package ordermicroservice.ordermicroservice.Repository;

import ordermicroservice.ordermicroservice.Model.SaveOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<SaveOrder,String> {
    //List<SaveOrder> getOrderByUserName(String userNameOrder);
}
