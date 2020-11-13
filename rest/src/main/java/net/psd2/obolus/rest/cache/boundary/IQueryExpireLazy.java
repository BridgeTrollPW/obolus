package net.psd2.obolus.rest.cache.boundary;

/**
 * If a cache object expires after N seconds, it will be refreshed within the
 * Object Broker A lazy expire will only check expire if the object is read from
 * the cache, there is no active checking
 */
public interface IQueryExpireLazy {
    long expireInSeconds();

    void refresh();
}
