package net.psd2.obolus.rest.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import net.psd2.obolus.rest.middleware.ContentTypeFilter;
import net.psd2.obolus.rest.resource.ecosystem.boundary.Ecosystem;
import net.psd2.obolus.rest.resource.pis.boundary.SinglePlaymentResource;

public class HTTPServer {
    private static final Logger LOG = LogManager.getLogger(HTTPServer.class);
    private static Server server;

    public static final String PROPERTY_REST_HOST = "rest.host";
    public static final String PROPERTY_REST_PORT = "rest.port";

    public static void start() throws UnknownHostException {
        String host = System.getProperty(PROPERTY_REST_HOST, "127.0.0.1");
        int port = Integer.parseInt(System.getProperty(PROPERTY_REST_PORT, "8448"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(host), port);

        server = new Server(inetSocketAddress);
        server.setHandler(context);
        ResourceConfig config = new ResourceConfig();
        // jetty hardening, handle any out of context errors
        context.setErrorHandler(new ErrorHandler());

        // Register Resources / REST Endpoints
        config.register(Ecosystem.class);
        config.register(SinglePlaymentResource.class);
        config.register(ContentTypeFilter.class);

        ServletHolder obolusRoutes = new ServletHolder(new ServletContainer(config));
        context.addServlet(obolusRoutes, "/v1/*");
        // context.addEventListener(new RequestUUIDAdapter()); // add uuid to every log
        // entry served for one single request

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            LOG.error("Error: {}", ex.getMessage());
        } finally {

            server.destroy();
        }
    }

    public void stopHttpServer() {
        if (server != null) {
            server.destroy();
            LOG.warn("Server has been stopped");
        }
    }

    // ErrorHandler is predefined by jetty

    @SuppressWarnings("squid:MaximumInheritanceDepth")
    static class ErrorHandler extends ErrorPageErrorHandler {

        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            LOG.error("An out of context error happened baseURI={} status={}", baseRequest.getRequestURI(),
                    response.getStatus());

        }
    }

}
