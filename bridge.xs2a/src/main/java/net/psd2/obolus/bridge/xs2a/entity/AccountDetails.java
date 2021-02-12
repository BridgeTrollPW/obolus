package net.psd2.obolus.bridge.xs2a.entity;

import java.util.Currency;
import java.util.List;

public class AccountDetails {

    /**
     * This is the data element to be used in the path when retrieving data from a
     * dedicated account, cp. Section 6.5.3 or Section 6.5.4 below. This shall be
     * filled, if addressable resource are created by the ASPSP on the /accounts
     * endpoint.
     */
    private String resourceId;
    /**
     * This data element can be used in the body of the Consent Request Message for
     * retrieving account access consent from this payment account, cp. Section
     * 6.3.1.1.
     */
    private String iban;
    /**
     * This data element can be used in the body of the Consent Request Message for
     * retrieving account access consent from this account, cp. Section 6.3.1.1.
     * This data elements is used for payment accounts which have no IBAN.
     */
    private String bban;
    /**
     * An alias to access a payment account via a registered mobile phone number.
     * This alias might be needed e.g. in the payment initiation service, cp.
     * Section 5.3.1. The support of this alias must be explicitly documented by the
     * ASPSP for the corresponding API Calls.
     */
    private String msisdn;
    /**
     * Account currency
     */
    private Currency currency;
    /**
     * Name of the legal account owner. If there is more than one owner, then e.g.
     * two names might be noted here. For a corporate account, the corporate name is
     * used for this attribute. Even if supported by the ASPSP, the provision of
     * this field might depend on the fact whether an explicit consent to this
     * specific additional account information has been given by the PSU.
     */
    private String ownerName;
    /**
     * Name of the account, as assigned by the ASPSP, in agreement with the account
     * owner in order to provide an additional means of identification of the
     * account.
     */
    private String name;
    /**
     * Name of the account as defined by the PSU within online channels.
     */
    private String displayName;
    /**
     * Product Name of the Bank for this account, proprietary definition
     */
    private String product;
    /**
     * ExternalCashAccountType1Code ISO 20022
     */
    private CachAccountType cashAccountType;
    /**
     * Account status. The value is one of the following:<br />
     * "enabled": account is available <br />
     * "deleted": account is terminated <br />
     * "blocked": account is blocked e.g. for legal reasons <br />
     * <br />
     * If this field is not used, than the account is available in the sense of this
     * specification.
     */
    private AccountStatus status;
    /**
     * The BIC associated to the account.
     */
    private String bic;
    /**
     * This data attribute is a field, where an ASPSP can name a cash account
     * associated to pending card transactions.
     */
    private String linkedAccounts;
    /**
     * Specifies the usage of the account
     */
    private AccountUsage usage;
    /**
     * Specifications that might be provided by the ASPSP
     */
    private String details;

    private List<Balance> balances;
    /**
     * Links to the account, which can be directly used for retrieving account
     * information from this dedicated account. Links to "balances" and/or
     * "transactions" These links are only supported, when the corresponding consent
     * has been already granted.
     */
    //BerlinGroup specification
    @SuppressWarnings("java:S116")
    private Links _links;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public CachAccountType getCashAccountType() {
        return cashAccountType;
    }

    public void setCashAccountType(CachAccountType cashAccountType) {
        this.cashAccountType = cashAccountType;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getLinkedAccounts() {
        return linkedAccounts;
    }

    public void setLinkedAccounts(String linkedAccounts) {
        this.linkedAccounts = linkedAccounts;
    }

    public AccountUsage getUsage() {
        return usage;
    }

    public void setUsage(AccountUsage usage) {
        this.usage = usage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

}
