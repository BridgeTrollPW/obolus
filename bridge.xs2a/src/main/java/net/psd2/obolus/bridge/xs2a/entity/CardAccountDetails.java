package net.psd2.obolus.bridge.xs2a.entity;

import java.util.Currency;
import java.util.List;

public class CardAccountDetails {
    private String resourceId;
    private String maskedPan;
    private Currency currency;
    private String ownerName;
    private String name;
    private String displayName;
    private String product;
    private AccountStatus status;
    private AccountUsage usage;
    private String details;
    private Amount creditLimit;
    private List<Balance> balances;
    private Links _links;

}
