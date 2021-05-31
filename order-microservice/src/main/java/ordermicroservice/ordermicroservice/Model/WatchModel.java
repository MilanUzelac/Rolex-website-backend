package ordermicroservice.ordermicroservice.Model;

public class WatchModel {
    private String model;
    private int price;
    private String imageWatchCard;

    public WatchModel(String model, int price, String imageWatchCard) {
        this.model = model;
        this.price = price;
        this.imageWatchCard = imageWatchCard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageWatchCard() {
        return imageWatchCard;
    }

    public void setImageWatchCard(String imageWatchCard) {
        this.imageWatchCard = imageWatchCard;
    }
}