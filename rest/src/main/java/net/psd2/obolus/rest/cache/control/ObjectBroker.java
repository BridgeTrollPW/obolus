package net.psd2.obolus.rest.cache.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.psd2.obolus.rest.cache.boundary.IQuery;
import net.psd2.obolus.rest.cache.boundary.IQueryResult;
import net.psd2.obolus.rest.cache.boundary.IQueryable;
import net.psd2.obolus.rest.cache.entity.CacheEntry;

public class ObjectBroker {
    private static final Logger logger = LogManager.getLogger(ObjectBroker.class);
    private List<CacheEntry> cache;

    private ObjectBroker() {
        logger.debug("ObjectBroker new allocation");
        cache = new ArrayList<>();
    }

    public static ObjectBroker getInstance() {
        return HOLDER.Instance;
    }

    private static class HOLDER {
        private static ObjectBroker Instance = new ObjectBroker();
    }

    public IQueryResult query(IQuery query) {
        Optional<CacheEntry> entry = cache.parallelStream()
                .filter((CacheEntry cacheEntry) -> cacheEntry.getObj().query(query) != null).findFirst();
//TODO check for optional empty -> Execption
        return entry.get().getObj().query(query);
    }

    public void cacheNew(IQueryable<? extends IQueryResult,? extends IQuery> obj) {
        //make type cast safe
        cache.add(new CacheEntry((IQueryable<IQueryResult, IQuery>) obj, new Date().getTime()));
    }
}
