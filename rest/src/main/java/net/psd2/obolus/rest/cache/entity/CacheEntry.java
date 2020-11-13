package net.psd2.obolus.rest.cache.entity;

import net.psd2.obolus.rest.cache.boundary.IQuery;
import net.psd2.obolus.rest.cache.boundary.IQueryResult;
import net.psd2.obolus.rest.cache.boundary.IQueryable;

public class CacheEntry {
    private IQueryable<IQueryResult, IQuery> obj;
    private long lastRefresh;

    public CacheEntry(IQueryable<IQueryResult, IQuery> obj, long lastRefresh) {
        this.setObj(obj);
        this.setLastRefresh(lastRefresh);
    }

    public long getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(long lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    public IQueryable<IQueryResult, IQuery> getObj() {
        return obj;
    }

    private void setObj(IQueryable<IQueryResult, IQuery> obj) {
        this.obj = obj;
    }

    
}
