package net.psd2.obolus.bridge.xs2a.entity;

import java.util.Currency;

public class Amount {
    /**
     * ISO 4217 Alpha 3 currency code
     */
    private Currency currency;
    /**
     * 
     * The amount given with fractional digits, where fractions must be compliant to
     * the currency definition. Up to 14 significant figures. Negative amounts are
     * signed by minus. The decimal separator is a dot. <br />
     * <b>Example:</b><br />
     *  Valid representations for EUR with up to two decimals are:     1056 5768.2
     * -1.50 5877.78
     */
    // BerlinGroup specification
    @SuppressWarnings("java:S1700")
    private String amount;

    public String getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
