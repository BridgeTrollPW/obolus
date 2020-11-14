package net.psd2.obolus.rest.cache.control;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.psd2.obolus.rest.cache.boundary.ICacheEntryExpireLazy;
import net.psd2.obolus.rest.cache.boundary.ICacheEntryObject;
import net.psd2.obolus.rest.cache.boundary.ICacheEntryRefresh;
import net.psd2.obolus.rest.cache.entity.CacheEntryWrapper;

public class ObjectBroker {
    private static final Logger logger = LogManager.getLogger(ObjectBroker.class);

    private Map<Class<? extends ICacheEntryObject>, CacheEntryWrapper> cache;

    // Flags
    private static final int BITFLAG_EXPIRED = 0b0001;//1
    private static final int BITFLAG_REFRESH = 0b0010;//2

    private ObjectBroker() {
        logger.debug("ObjectBroker new allocation");
        cache = new HashMap<>();
    }

    public static ObjectBroker getInstance() {
        return HOLDER.instance;
    }

    private static class HOLDER {
        private static final ObjectBroker instance = new ObjectBroker();
    }

    public void store(ICacheEntryObject newObject) {
        cache.put(newObject.getClass(), new CacheEntryWrapper(newObject, new Date().getTime()));
    }

    public <T extends ICacheEntryObject> T fetch(Class<? extends T> clazz) {
        ICacheEntryObject obj = cache.get(clazz).getObject();
        int flags = 0;
        if (obj instanceof ICacheEntryExpireLazy) {
            flags |= BITFLAG_EXPIRED;
        }

        if (obj instanceof ICacheEntryRefresh) {
            flags |= BITFLAG_REFRESH;
        }

        if ((flags & BITFLAG_EXPIRED) == BITFLAG_EXPIRED) {
            cache.remove(clazz);
            return null;
        }
        if ((flags & BITFLAG_REFRESH) == BITFLAG_REFRESH) {
            obj = ((ICacheEntryRefresh) obj).refresh();
            cache.put(clazz, new CacheEntryWrapper(obj, new Date().getTime()));
        }
        return (T)obj;
    }
}
