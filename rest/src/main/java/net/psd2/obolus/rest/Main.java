package net.psd2.obolus.rest;

import net.psd2.obolus.rest.server.HTTPServer;

public class Main {
    public static void main(String[] args) throws Exception {
        new HTTPServer().startHttpServer();
    }
}
