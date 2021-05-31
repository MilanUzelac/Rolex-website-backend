package ordermicroservice.ordermicroservice.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "order_collection")
public class SaveOrder {
    @Id
    private String userNameOrder;
    private List<WatchModel> orderedWatches;
    private String chosenCity;
    private int finalPrice;
    private Date estimatedDate;

    public SaveOrder(String userNameOrder, List<WatchModel> orderedWatches, String chosenCity,Date estimatedDate) {
        this.userNameOrder = userNameOrder;
        this.orderedWatches = orderedWatches;
        this.chosenCity = chosenCity;
        this.finalPrice = orderedWatches.stream().map(WatchModel::getPrice).mapToInt(Integer::intValue).sum();
        this.estimatedDate = estimatedDate;
    }

    public String getUserNameOrder() {
        return userNameOrder;
    }

    public void setUserNameOrder(String userNameOrder) {
        this.userNameOrder = userNameOrder;
    }

    public List<WatchModel> getOrderedWatches() {
        return orderedWatches;
    }

    public void setOrderedWatches(List<WatchModel> orderedWatches) {
        this.orderedWatches = orderedWatches;
    }

    public String getChosenCity() {
        return chosenCity;
    }

    public void setChosenCity(String chosenCity) {
        this.chosenCity = chosenCity;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    @Override
    public String toString() {
        return "SaveOrder{" +
                "userNameOrder='" + userNameOrder + '\'' +
                ", orderedWatches=" + orderedWatches +
                ", chosenCity='" + chosenCity + '\'' +
                ", finalPrice=" + finalPrice +
                ", estimatedDate=" + estimatedDate +
                '}';
    }
}
