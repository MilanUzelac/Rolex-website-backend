package ordermicroservice.ordermicroservice.Model.Watch;

public class WatchBracelet {
    private String imageBracelet;
    private String bracelet;
    private String braceletMaterial;
    private String clasp;

    public WatchBracelet(String imageBracelet, String bracelet, String braceletMaterial, String clasp) {
        this.imageBracelet = imageBracelet;
        this.bracelet = bracelet;
        this.braceletMaterial = braceletMaterial;
        this.clasp = clasp;
    }

    public String getImageBracelet() {
        return imageBracelet;
    }

    public void setImageBracelet(String imageBracelet) {
        this.imageBracelet = imageBracelet;
    }

    public String getBracelet() {
        return bracelet;
    }

    public void setBracelet(String bracelet) {
        this.bracelet = bracelet;
    }

    public String getBraceletMaterial() {
        return braceletMaterial;
    }

    public void setBraceletMaterial(String braceletMaterial) {
        this.braceletMaterial = braceletMaterial;
    }

    public String getClasp() {
        return clasp;
    }

    public void setClasp(String clasp) {
        this.clasp = clasp;
    }
}
