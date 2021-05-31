package ordermicroservice.ordermicroservice.Model.Watch;

public class WatchMovement {
    private String imageMovement;
    private String movement;
    private String calibre;
    private String precision;
    private String functions;
    private String oscilator;
    private String winding;
    private String powerReserve;

    public WatchMovement(String imageMovement, String movement, String calibre, String precision, String functions, String oscilator, String winding, String powerReserve) {
        this.imageMovement = imageMovement;
        this.movement = movement;
        this.calibre = calibre;
        this.precision = precision;
        this.functions = functions;
        this.oscilator = oscilator;
        this.winding = winding;
        this.powerReserve = powerReserve;
    }

    public String getImageMovement() {
        return imageMovement;
    }

    public void setImageMovement(String imageMovement) {
        this.imageMovement = imageMovement;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getOscilator() {
        return oscilator;
    }

    public void setOscilator(String oscilator) {
        this.oscilator = oscilator;
    }

    public String getWinding() {
        return winding;
    }

    public void setWinding(String winding) {
        this.winding = winding;
    }

    public String getPowerReserve() {
        return powerReserve;
    }

    public void setPowerReserve(String powerReserve) {
        this.powerReserve = powerReserve;
    }
}
