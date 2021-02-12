package net.psd2.obolus.bridge.xs2a.entity;

public class AuthenticationObject {
    /**
     * Type of the authentication method.
     */
    private AuthenticationType authenticationType;
    /**
     * Depending "authenticationType". This version can be used by differentiating
     * authentication tools used within performing OTP generation in the same
     * authentication type. This version can be referred to in the ASPSP’s
     * documentation.
     */
    private String authenticationVersion;
    /**
     * An identification provided by the ASPSP for the later identification of the
     * authentication method selection.
     */
    private String authenticationMethodId;
    /**
     * This is the name of the authentication method defined by the PSU in the
     * Online Banking frontend of the ASPSP. Alternatively this could be a
     * description provided by the ASPSP like "SMS OTP on phone +49160 xxxxx 28".
     * This name shall be used by the TPP when presenting a list of authentication
     * methods to the PSU, if available.
     */
    private String name;
    /**
     * detailed information about the SCA method for the PSU
     */
    private String explanation;

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getAuthenticationVersion() {
        return authenticationVersion;
    }

    public void setAuthenticationVersion(String authenticationVersion) {
        this.authenticationVersion = authenticationVersion;
    }

    public String getAuthenticationMethodId() {
        return authenticationMethodId;
    }

    public void setAuthenticationMethodId(String authenticationMethodId) {
        this.authenticationMethodId = authenticationMethodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
