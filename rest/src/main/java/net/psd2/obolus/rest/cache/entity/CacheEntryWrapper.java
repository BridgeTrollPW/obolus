package net.psd2.obolus.rest.cache.entity;

import net.psd2.obolus.rest.cache.boundary.ICacheEntryObject;

public class CacheEntryWrapper {
    private ICacheEntryObject obj;
    private long storedAt;

    public CacheEntryWrapper(ICacheEntryObject obj, long storedAt) {
        this.obj = obj;
        this.storedAt = storedAt;
    }

    public ICacheEntryObject getObject() {
        return obj;
    }

    public long getStoredAt() {
        return storedAt;
    }
}
