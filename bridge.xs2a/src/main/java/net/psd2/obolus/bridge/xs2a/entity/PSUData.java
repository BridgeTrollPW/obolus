package net.psd2.obolus.bridge.xs2a.entity;

public class PSUData {
    /**
     * Contains a password in plaintext.
     */
    private String password;
    /**
     * Is used when a password is encrypted on application level.
     */
    private String encryptedPassword;
    /**
     * Contains an additional password in plaintext
     */
    private String additionalPassword;
    /**
     * Is provided when the additional password is used and is encrypted on
     * application level.
     */
    private String additionalEncryptedPassword;

    public String getAdditionalEncryptedPassword() {
        return additionalEncryptedPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getAdditionalPassword() {
        return additionalPassword;
    }

    public void setAdditionalPassword(String additionalPassword) {
        this.additionalPassword = additionalPassword;
    }

    public void setAdditionalEncryptedPassword(String additionalEncryptedPassword) {
        this.additionalEncryptedPassword = additionalEncryptedPassword;
    }

}
