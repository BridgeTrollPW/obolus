package net.psd2.obolus.rest.cache.boundary;

public interface ICacheEntryRefresh {
    /**
     * This method is called whenever an object needs to be refreshed within the
     * ObjectBroker An example would be if oyu have an object that can expire within
     * the ObjectBroker. Instead of just discarding the object, a new/refreshed
     * object takes its place
     */
    ICacheEntryObject refresh();
}
