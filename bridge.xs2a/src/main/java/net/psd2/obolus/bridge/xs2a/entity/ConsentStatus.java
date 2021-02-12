package net.psd2.obolus.bridge.xs2a.entity;

//BerlinGroup specification
@SuppressWarnings("java:S115")
public enum ConsentStatus {
    /**
     * The consent data have been received and are technically correct. The data is
     * not authorised yet.
     */
    received,
    /**
     * The consent data have been rejected e.g. since no successful authorisation
     * has taken place.
     */
    rejected,
    /**
     * The consent is due to a multi-level authorisation, some but not all mandated
     * authorisations have been performed yet.
     */
    partiallyAuthorised,
    /**
     * The consent is accepted and valid for GET account data calls and others as
     * specified in the consent object.
     */
    valid,
    /**
     * The consent has been revoked by the PSU towards the ASPSP.
     */
    recokedByPsu,
    /**
     * The consent expired.
     */
    expired,
    /**
     * The corresponding TPP has terminated the consent by applying the DELETE
     * method to the consent resource.
     */
    terminatedByTpp;

}
