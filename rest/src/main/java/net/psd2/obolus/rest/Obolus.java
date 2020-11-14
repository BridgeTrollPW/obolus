package net.psd2.obolus.rest;

import java.net.UnknownHostException;

import net.psd2.obolus.rest.cache.control.ObjectBroker;
import net.psd2.obolus.rest.server.ConfigProvider;
import net.psd2.obolus.rest.server.HTTPServer;

public class Obolus {
    public static void main(String[] args) throws UnknownHostException {
        ObjectBroker.getInstance().store(new ConfigProvider());
        HTTPServer.start();
    }
}
