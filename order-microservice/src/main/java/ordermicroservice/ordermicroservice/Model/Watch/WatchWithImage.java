package ordermicroservice.ordermicroservice.Model.Watch;

import java.util.List;

public class WatchWithImage {

    private long watchId;
    private String gender;
    private String watchType;
    private String imageWatchCard;
    private String model;
    private String desc;
    private int price;
    private String strPrice;
    private String imageBackground;
    private String imageWatch;
    private String nightImage;
    private StaticTextShortAbout staticTextShortAbout;
    private List<WatchFeatures> watchFeatures;
    private String rolexBoxImage;
    private ModelCase modelCase;
    private WatchMovement watchMovement;
    private WatchBracelet watchBracelet;
    private WatchDial watchDial;
    private WatchCertification watchCertification;
    private String orderBackgroundImage;

    public WatchWithImage(long watchId, String gender, String watchType, String imageWatchCard, String model, String desc, int price, String strPrice, String imageBackground, String imageWatch, String nightImage, StaticTextShortAbout staticTextShortAbout, List<WatchFeatures> watchFeatures, String rolexBoxImage, ModelCase modelCase, WatchMovement watchMovement, WatchBracelet watchBracelet, WatchDial watchDial, WatchCertification watchCertification, String orderBackgroundImage) {
        this.watchId = watchId;
        this.gender = gender;
        this.watchType = watchType;
        this.imageWatchCard = imageWatchCard;
        this.model = model;
        this.desc = desc;
        this.price = price;
        this.strPrice = strPrice;
        this.imageBackground = imageBackground;
        this.imageWatch = imageWatch;
        this.nightImage = nightImage;
        this.staticTextShortAbout = staticTextShortAbout;
        this.watchFeatures = watchFeatures;
        this.rolexBoxImage = rolexBoxImage;
        this.modelCase = modelCase;
        this.watchMovement = watchMovement;
        this.watchBracelet = watchBracelet;
        this.watchDial = watchDial;
        this.watchCertification = watchCertification;
        this.orderBackgroundImage = orderBackgroundImage;
    }

    public long getWatchId() {
        return watchId;
    }

    public void setWatchId(long watchId) {
        this.watchId = watchId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWatchType() {
        return watchType;
    }

    public void setWatchType(String watchType) {
        this.watchType = watchType;
    }

    public String getImageWatchCard() {
        return imageWatchCard;
    }

    public void setImageWatchCard(String imageWatchCard) {
        this.imageWatchCard = imageWatchCard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStrPrice() {
        return strPrice;
    }

    public void setStrPrice(String strPrice) {
        this.strPrice = strPrice;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public String getImageWatch() {
        return imageWatch;
    }

    public void setImageWatch(String imageWatch) {
        this.imageWatch = imageWatch;
    }

    public String getNightImage() {
        return nightImage;
    }

    public void setNightImage(String nightImage) {
        this.nightImage = nightImage;
    }

    public StaticTextShortAbout getStaticTextShortAbout() {
        return staticTextShortAbout;
    }

    public void setStaticTextShortAbout(StaticTextShortAbout staticTextShortAbout) {
        this.staticTextShortAbout = staticTextShortAbout;
    }

    public List<WatchFeatures> getWatchFeatures() {
        return watchFeatures;
    }

    public void setWatchFeatures(List<WatchFeatures> watchFeatures) {
        this.watchFeatures = watchFeatures;
    }

    public String getRolexBoxImage() {
        return rolexBoxImage;
    }

    public void setRolexBoxImage(String rolexBoxImage) {
        this.rolexBoxImage = rolexBoxImage;
    }

    public ModelCase getModelCase() {
        return modelCase;
    }

    public void setModelCase(ModelCase modelCase) {
        this.modelCase = modelCase;
    }

    public WatchMovement getWatchMovement() {
        return watchMovement;
    }

    public void setWatchMovement(WatchMovement watchMovement) {
        this.watchMovement = watchMovement;
    }

    public WatchBracelet getWatchBracelet() {
        return watchBracelet;
    }

    public void setWatchBracelet(WatchBracelet watchBracelet) {
        this.watchBracelet = watchBracelet;
    }

    public WatchDial getWatchDial() {
        return watchDial;
    }

    public void setWatchDial(WatchDial watchDial) {
        this.watchDial = watchDial;
    }

    public WatchCertification getWatchCertification() {
        return watchCertification;
    }

    public void setWatchCertification(WatchCertification watchCertification) {
        this.watchCertification = watchCertification;
    }

    public String getOrderBackgroundImage() {
        return orderBackgroundImage;
    }

    public void setOrderBackgroundImage(String orderBackgroundImage) {
        this.orderBackgroundImage = orderBackgroundImage;
    }
}
