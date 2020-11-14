package net.psd2.obolus.rest.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.psd2.obolus.rest.cache.boundary.ICacheEntryExpireLazy;
import net.psd2.obolus.rest.cache.boundary.ICacheEntryObject;
import net.psd2.obolus.rest.cache.boundary.ICacheEntryRefresh;

public class ConfigProvider implements ICacheEntryObject, ICacheEntryExpireLazy, ICacheEntryRefresh {
    private static final Logger logger = LogManager.getLogger(ConfigProvider.class);

    public static final String PROPERTY_PATH = "obolus.config.path";
    public static final String PROPERTY_EXPIRE_IN_SECONDS = "rest.configprovider.expireInSeconds";

    private long expiry;

    public ConfigProvider() {
        String configuratonFilePath = System.getProperty(PROPERTY_PATH, "application.properties");
        try (FileInputStream fStream = new FileInputStream(new File(configuratonFilePath))) {
            System.getProperties().load(fStream);
        } catch (IOException e) {
            logger.error("Unable to load configuration from path={}", configuratonFilePath, e);
        }
        expiry = Long.parseLong(System.getProperty(PROPERTY_EXPIRE_IN_SECONDS, "120"));
    }

    /**
     * Re-reads the configuration file and adds it to the system properties
     */
    @Override
    public ICacheEntryObject refresh() {
        logger.info("Configuration is refreshed");
        return new ConfigProvider();
    }

    @Override
    public long expireAfterSeconds() {
        return expiry;
    }

}
