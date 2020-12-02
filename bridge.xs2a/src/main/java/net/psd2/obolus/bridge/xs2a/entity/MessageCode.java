package net.psd2.obolus.bridge.xs2a.entity;

import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public enum MessageCode implements StatusType {
    CERTIFICATE_INVALID(401,
            "The contents of the signature/corporate seal certificate are not matching PSD2 general PSD2 or attribute requirements."),
    ROLE_INVALID(401, "The TPP does not have the correct PSD2 role to access this service."),
    CERTIFICATE_EXPIRED(401, "Signature/corporate seal certificate is expired."),
    CERTIFICATE_BLOCKED(401, "Signature/corporate seal certificate has been blocked by the ASPSP or the related NCA."),
    CERTIFICATE_REVOKED(401, "Signature/corporate seal certificate has been revoked by QSTP."),
    CERTIFICATE_MISSING(401,
            "Signature/corporate seal certificate was not available in the request but is mandated for the corresponding."),
    SIGNATURE_INVALID(401, "Application layer eIDAS Signature for TPP authentication is not correct."),
    SIGNATURE_MISSING(401,
            "Application layer eIDAS Signature for TPP authentication is mandated by the ASPSP but is missing."),
    FORMAT_ERROR(400,
            "Format of certain request fields are not matching the XS2A requirements. An explicit path to the corresponding field might be added in the return message. This applies to headers and body entries. It also applies in cases where these entries are referring to erroneous or not existing data instances, e.g. a malformed IBAN."),
    PARAMETER_NOT_CONSISTENT(400,
            "Parameters submitted by TPP are not consistent. This applies only for query parameters."),
    PARAMETER_NOT_SUPPORTED(400,
            "The parameter is not supported by the API provider. This code should only be used for parameters that are described as optional if supported by API provider."),
    PSU_CREDENTIALS_INVALID(401,
            "The PSU-ID cannot be matched by the addressed ASPSP or is blocked, or a password resp. OTP was not correct. Additional information might be added."),
    SERVICE_INVALID(400,
            "(if payload) The addressed service is not valid for the addressed resources or the submitted data. 405 (if HTTP method)"),
    SERVICE_BLOCKED(403,
            "This service is not reachable for the addressed PSU due to a channel independent blocking by the ASPSP. Additional information might be given by the ASPSP."),
    CORPORATE_ID_INVALID(401, "The PSU-Corporate-ID cannot be matched by the addressed ASPSP."),
    CONSENT_UNKNOWN(403,
            "(if path) The Consent-ID cannot be matched by the ASPSP relative to the TPP. 400 (if header)"),
    CONSENT_INVALID(401, "The consent was created by this TPP but is not valid for the addressed service/resource."),
    CONSENT_EXPIRED(401, "The consent was created by this TPP but has expired and needs to be renewed."),
    TOKEN_UNKNOWN(401, "The OAuth2 token cannot be matched by the ASPSP relative to the TPP."),
    TOKEN_INVALID(401,
            "The OAuth2 token is associated to the TPP but is not valid for the addressed service/resource."),
    TOKEN_EXPIRED(401, "The OAuth2 token is associated to the TPP but has expired and needs to be renewed."),
    RESOURCE_UNKNOWN(404,
            "The addressed resource is unknown relative to the TPP. An example for a payload reference is creating a signing basket with an unknown resource identficiation."),
    RESOURCE_EXPIRED(403,
            "The addressed resource is associated with the TPP but has expired, not addressable anymore."),
    RESOURCE_BLOCKED(400,
            "The addressed resource is not addressable by this request, since it is blocked e.g. by a grouping in a signing basket."),
    TIMESTAMP_INVALID(400, "Timestamp not in accepted time period."),
    PERIOD_INVALID(400, "Requested time period out of bound."),
    SCA_METHOD_UNKNOWN(400,
            "Addressed SCA method in the Authentication Method Select Request is unknown or cannot be matched by the ASPSP with the PSU."),
    SCA_INVALID(400,
            "Method Application on authorisation resource (e.g. Confirmation Request) blocked since SCA status of the resource equals failed."),
    STATUS_INVALID(409, "The addressed resource does not allow addtitional authorisation."),
    PRODUCT_INVALID(403, "The addressed payment product is not available for the PSU ."),
    PRODUCT_UNKNOWN(404, "The addressed payment product is not supported by the ASPSP."),
    PAYMENT_FAILED(400,
            "The payment initiation POST request failed during the initial process. Additional information may be provided by the ASPSP."),
    REQUIRED_KID_MISSING(401,
            "The payment initiation has failed due to a missing KID. This is a specific message code for the Norwegian market, where ASPSP can require the payer to transmit the KID."),
    EXECUTION_DATE_INVALID(400, "The requested execution date is not a valid execution date for the ASPSP."),
    CANCELLATION_INVALID(405,
            "The addressed payment is not cancellable e.g due to cut off time passed or legal constraints."),
    SESSIONS_NOT_SUPPORTED(400, "The combined service flag may not be used with this ASPSP."),
    ACCESS_EXCEEDED(429,
            "The access on the account has been exceeding the consented multiplicity without PSU involvement per day."),
    REQUESTED_FORMATS_INVALID(406,
            "The requested formats in the Accept headerentry are not matching the formats offered by the ASPSP."),
    CARD_INVALID(400, "Addressed card number is unknown to the ASPSP or not associated to the PSU."),
    NO_PIIS_ACTIVATION(400,
            "The PSU has not activated the addressed account for the usage usage of the PIIS associated with the TPP."),
    REFERENCE_MIX_INVALID(400,
            "The used combination of referenced objects is not supported in the ASPSPs signing basket function."),
    REFERENCE_STATUS_INVALID(409, "At least one of the references is already fully authorised.");

    private int code;
    private Family family;
    private String reason;

    MessageCode(int code, Family family, String reason) {
        this.code = code;
        this.family = family;
        this.reason = reason;
    }

    MessageCode(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public int getStatusCode() {
        return code;
    }

    @Override
    public Family getFamily() {
        return family;
    }

    @Override
    public String getReasonPhrase() {
        return reason;
    }

}
