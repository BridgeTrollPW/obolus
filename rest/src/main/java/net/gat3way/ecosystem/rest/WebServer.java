package net.gat3way.ecosystem.rest;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class WebServer {
    private static final Logger LOG = LogManager.getLogger(WebServer.class);
    private final String ip;
    private final String port;
    private Server server = null;

    public WebServer() {
        this.ip = "127.0.0.1";
        this.port = "8444";
    }

    public void startHttpServer() throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(ip), Integer.parseInt(port));

        server = new Server(inetSocketAddress);
        server.setHandler(context);
        ResourceConfig config = new ResourceConfig();
        // jetty hardening, handle any out of context errors
        // context.setErrorHandler(new ErrorHandler());

        // Register Resources / REST Endpoints
        // config.register(CallbackResource.class);

        ServletHolder styxRoutes = new ServletHolder(new ServletContainer(config));
        context.addServlet(styxRoutes, "/*");
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
    /*
     * // ErrorHandler is predefined by jetty
     * 
     * @SuppressWarnings("squid:MaximumInheritanceDepth") static class ErrorHandler
     * extends ErrorPageErrorHandler {
     * 
     * @Override public void handle(String target, Request baseRequest,
     * HttpServletRequest request, HttpServletResponse response) throws IOException
     * { LOG.error("An out of context error happened baseURI={} status={}",
     * baseRequest.getRequestURI(), response.getStatus()); ResponseEntity
     * responseEntity = new ResponseEntity("Internal Server Error",
     * ResponseConstant.INTERNAL_SERVER_ERROR, ResponseCategory.ERROR,
     * ResponseOrigin.STYX); try (Jsonb jsonb = JsonbBuilder.create()) {
     * response.setStatus(ResponseConstant.INTERNAL_SERVER_ERROR.getStatusCode());
     * response.setContentType(MediaType.APPLICATION_JSON);
     * response.getWriter().append(jsonb.toJson(responseEntity)); } catch (Exception
     * e) { response.setContentType(MediaType.APPLICATION_JSON);
     * response.getWriter().append("{\"message\": \"Internal Server error\"}"); } }
     * }
     */
}
