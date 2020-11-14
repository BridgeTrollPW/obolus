package net.psd2.obolus.rest.cache.boundary;

public interface ICacheEntryExpireLazy {
    /**
     * Returns amount of seconds after which this object shall be marked as expired
     * by the ObjectBroker Expiry is checked <b>lazily</b> which means, only if a
     * read operation is performed on this object, expiry will be checked
     * 
     * @see net.psd2.obolus.rest.cache.control.ObjectBroker
     */
    long expireAfterSeconds();
}
