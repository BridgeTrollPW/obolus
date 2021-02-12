package net.psd2.obolus.bridge.xs2a.entity;

public enum TransactionStatus {
    /**
     * Settlement on the creditor's account has been completed.
     */
    ACCC("AcceptedSettlementCompleted"),
    /**
     * Preceding check of technical validation was successful. Customer profile
     * check was also successful.
     */
    ACCP("AcceptedCustomerProfile"),
    /**
     * Settlement on the debtor’s account has been completed. Usage: this can be
     * used by the first agent to report to the debtor that the transaction has been
     * completed. Warning: this status is provided for transaction status reasons,
     * not for financial information. It can only be used after bilateral agreement
     */
    ACSC("AcceptedSettlementCompleted"),
    /**
     * All preceding checks such as technical validation and customer profile were
     * successful and therefore the payment initiation has been accepted for
     * execution.
     */
    ACSP("AcceptedSettlementInProcess"),
    /**
     * Authentication and syntactical and semantical validation are successful
     */
    ACTC("AcceptedTechnicalValidation"),
    /**
     * Instruction is accepted but a change will be made, such as date or remittance
     * not sent.
     */
    ACWC("AcceptedWithChange"),
    /**
     * Payment instruction included in the credit transfer is accepted without being
     * posted to the creditor customer’s account.
     */
    ACWP("AcceptedWithoutPosting"),
    /**
     * Payment initiation has been received by the receiving agent.
     */
    RCVD("Received"),
    /**
     * Payment initiation or individual transaction included in the payment
     * initiation is pending. Further checks and status update will be performed.
     */
    PDNG("Pending"),
    /**
     * Payment initiation or individual transaction included in the payment
     * initiation has been rejected.
     */
    RJCT("Rejected"),
    /**
     * Payment initiation has been cancelled before execution Remark: This code is
     * accepted as new code by ISO20022.
     */
    CANC("Cancelled"),
    /**
     * Pre-ceeding check of technical validation and customer profile was successful
     * and an automatic funds check was positive . Remark: This code is accepted as
     * new code by ISO20022.
     */
    ACFC("AcceptedFundsChecked"),
    /**
     * The payment initiation needs multiple authentications, where some but not yet
     * all have been performed. Syntactical and semantical validations are
     * successful. Remark: This code is is accepted as new code by ISO20022.
     */
    PATC("PartiallyAcceptedTechnicalCorrect"),
    /**
     * A number of transactions have been accepted, whereas another number of
     * transactions have not yet achieved 'accepted' status. Remark: This code may
     * be used only in case of bulk payments. It is only used in a situation where
     * all mandated authorisations have been applied, but some payments have been
     * rejected.
     */
    PART("PartiallyAccepted");

    private String name;

    TransactionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
