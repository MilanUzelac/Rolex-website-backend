package ordermicroservice.ordermicroservice.Model.Watch;

public class WatchCertification {
    private String certificationImage;
    private String certification;

    public WatchCertification(String certificationImage, String certification) {
        this.certificationImage = certificationImage;
        this.certification = certification;
    }

    public String getCertificationImage() {
        return certificationImage;
    }

    public void setCertificationImage(String certificationImage) {
        this.certificationImage = certificationImage;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}
