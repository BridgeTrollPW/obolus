package net.psd2.obolus.bridge.xs2a.entity;

//BerlinGroup specification
@SuppressWarnings("java:S115")
public enum BalanceType {
    /**
     * Balance of the account at the end of the pre-agreed account reporting period.
     * It is the sum of the opening booked balance at the beginning of the period
     * and all entries booked to the account during the pre-agreed account reporting
     * period.<br />
     * <br />
     * For card-accounts, this is composed of <br />
     * <br />
     * <ul>
     * <li>invoiced, but not yet paid entries</li>
     * </ul>
     */
    closingBooked,
    /**
     * Balance composed of booked entries and pending items known at the time of
     * calculation, which projects the end of day balance if everything is booked on
     * the account and no other entry is posted. For card accounts, this is composed
     * of <br />
     * <br />
     * <ul>
     * <li>invoiced, but not yet paid entries,</li>
     * <li>not yet invoiced but already booked entries and</li>
     * <li>pending items (not yet booked)</li>
     * </ul>
     */
    expected, 
    openingBooked, interimAvailable, interimBooked, forwardAvailable, nonInvoiced
}
