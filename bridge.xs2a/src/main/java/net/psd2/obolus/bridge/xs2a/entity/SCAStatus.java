package net.psd2.obolus.bridge.xs2a.entity;

//BerlinGroup specification
@SuppressWarnings("java:S115")
public enum SCAStatus {
    /**
     * An authorisation or cancellation-authorisation resource has been created
     * successfully.
     */
    received,
    /**
     * The PSU related to the authorisation or cancellation-authorisation resource
     * has been identified.
     */
    psuIdentified,
    /**
     * The PSU related to the authorisation or cancellation-authorisation resource
     * has been identified and authenticated e.g. by a password or by an access
     * token.
     */
    psuAuthenticated,
    /**
     * The PSU/TPP has selected the related SCA routine. If the SCA method is chosen
     * implicitly since only one SCA method is available, then this is the first
     * status to be reported instead of "received".
     */
    scaMethodSelected,
    /**
     * The addressed SCA routine has been started.
     */
    started,
    /**
     * SCA is technically successfully finalised by the PSU, but the authorisation
     * resource needs a confirmation command by the TPP yet.
     */
    unconfirmed,
    /**
     * The SCA routine has been finalised successfully (including a potential
     * confirmation command). This is a final status of the authorisation resource.
     */
    finalised,
    /**
     * The SCA routine failed. This is a final status of the authorisation resource.
     */
    failed,
    /**
     * SCA was exempted for the related transaction, the related authorisation is
     * successful. This is a final status of the authorisation resource.
     */
    exempted
}
