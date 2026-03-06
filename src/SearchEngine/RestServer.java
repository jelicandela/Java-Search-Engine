package SearchEngine;

import java.net.URI;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import java.io.IOException;

/**
 * Initializes and configures the Grizzly HTTP server to host the 
 * Jersey (JAX-RS) REST API endpoints for the search engine.
 * * @author Andela Jelic
 */

public class RestServer {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/search-engine/";

    public static HttpServer startServer() {
        // Using our custom MyApplication config
        final ResourceConfig rc = new MyApplication();

        // Creating and starting a new instance of grizzly http server
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        
        System.in.read();
        server.shutdownNow();
    }
}