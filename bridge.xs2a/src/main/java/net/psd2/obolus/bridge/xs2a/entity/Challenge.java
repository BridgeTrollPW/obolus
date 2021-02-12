package net.psd2.obolus.bridge.xs2a.entity;

import java.util.List;

public class Challenge {
    /**
     * PNG data (max. 512 kilobyte) to be displayed to the PSU, Base64 encoding, cp.
     * [RFC4648]. This attribute is used only, when PHOTO_OTP or CHIP_OTP is the
     * selected SCA method.
     */
    private String image;
    /**
     * A collection of challenge data
     */
    private List<String> data;
    /**
     * A link where the ASPSP will provides the challenge image for the TPP.
     */
    private String imageLink;
    /**
     * The maximal length for the OTP to be typed in by the PSU.
     */
    private Integer otpMaxLength;
    /**
     * The format type of the OTP to be typed in. The admitted values are
     * "characters" or "integer".
     */
    private String otpFormat;
    /**
     * Additional explanation for the PSU to explain e.g. fallback mechanism for the
     * chosen SCA method. The TPP is obliged to show this to the PSU.
     */
    private String additionalInformation;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getOtpMaxLength() {
        return otpMaxLength;
    }

    public void setOtpMaxLength(Integer otpMaxLength) {
        this.otpMaxLength = otpMaxLength;
    }

    public String getOtpFormat() {
        return otpFormat;
    }

    public void setOtpFormat(String otpFormat) {
        this.otpFormat = otpFormat;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
