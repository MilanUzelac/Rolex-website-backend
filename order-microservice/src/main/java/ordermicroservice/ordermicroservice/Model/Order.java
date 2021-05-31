package ordermicroservice.ordermicroservice.Model;

import java.util.Date;
import java.util.List;

public class Order {
    private String userNameOrder;
    private User user;
    private List<WatchModel> orderedWatchesDetails;
    private String chosenCity;
    private int finalPrice;
    private Date estimatedDate;

    public Order(String userNameOrder, User user, List<WatchModel> orderedWatchesDetails, String chosenCity,int finalPrice, Date estimatedDate) {
        this.userNameOrder = userNameOrder;
        this.user = user;
        this.orderedWatchesDetails = orderedWatchesDetails;
        this.chosenCity = chosenCity;
        this.finalPrice = finalPrice;
        this.estimatedDate = estimatedDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userNameOrder='" + userNameOrder + '\'' +
                ", userDetails=" + user +
                ", orderedWatchesDetails=" + orderedWatchesDetails +
                ", chosenCity='" + chosenCity + '\'' +
                ", finalPrice=" + finalPrice +
                ", estimatedDate=" + estimatedDate +
                '}';
    }

    public String getUserNameOrder() {
        return userNameOrder;
    }

    public void setUserNameOrder(String userNameOrder) {
        this.userNameOrder = userNameOrder;
    }

    public User getUserDetails() {
        return user;
    }

    public void setUserDetails(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WatchModel> getOrderedWatchesDetails() {
        return orderedWatchesDetails;
    }

    public void setOrderedWatchesDetails(List<WatchModel> orderedWatchesDetails) {
        this.orderedWatchesDetails = orderedWatchesDetails;
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
}
