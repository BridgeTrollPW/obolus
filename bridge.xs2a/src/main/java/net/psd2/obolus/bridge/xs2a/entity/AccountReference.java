package net.psd2.obolus.bridge.xs2a.entity;

import java.util.Currency;

public class AccountReference {
    private String iban;
    /**
     * This data elements is used for payment accounts which have no IBAN.
     */
    private String bban;
    /**
     * Primary Account Number (PAN) of a card, can be tokenised by the ASPSP due to
     * PCI DSS requirements.
     */
    private String pan;
    /**
     * Primary Account Number (PAN) of a card in a masked form.
     */
    private String maskedPan;
    /**
     * An alias to access a payment account via a registered mobile phone number.
     */
    private String msisdn;
    /**
     * ISO 4217 Alpha 3 currency code
     */
    private Currency currency;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBban() {
        return bban;
    }

    public void setBban(String bban) {
        this.bban = bban;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
