package net.psd2.obolus.rest.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.psd2.obolus.rest.cache.boundary.IQuery;
import net.psd2.obolus.rest.cache.boundary.IQueryExpireLazy;
import net.psd2.obolus.rest.cache.boundary.IQueryResult;
import net.psd2.obolus.rest.cache.boundary.IQueryable;

public class ConfigProvider
        implements IQueryable<ConfigProvider,ConfigProvider>, IQueryExpireLazy, IQueryResult, IQuery {
    public static final Logger logger = LogManager.getLogger(ConfigProvider.class);
    public static final String PROPERTY_PATH = "obolus.config.path";

    public ConfigProvider() {
        String configuratonFilePath = System.getProperty(PROPERTY_PATH, "application.properties");
        try (FileInputStream fStream = new FileInputStream(new File(configuratonFilePath))) {
            System.getProperties().load(fStream);
        } catch (IOException e) {
            logger.error("Unable to load configuration from path={}", configuratonFilePath, e);
        }
    }

    @Override
    public long expireInSeconds() {
        // TODO Auto-generated method stub
        return 500;
    }

    @Override
    public ConfigProvider query(ConfigProvider query) {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public void refresh() {
        // asdas a
    }

}
