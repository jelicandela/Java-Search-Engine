package SearchEngine;

import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * REST Controller handling incoming HTTP requests for search operations.
 * Exposes endpoints for standard querying and triggering the web crawler.
 * * @author Andela Jelic
 */

@Path("/search")
public class SearchResource {

    // Standard Search (GET /search?q=...)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("q") String query) {
        if (query == null || query.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Query missing").build();
        }

        // Logic: Execute search via Index Singleton
        System.out.println("API: Searching for " + query);
        ResultList results = Index.getInstance().search(query);
        
        return Response.ok(results.getResults()).build();
    }

    // Triggering Crawler (POST /search with JSON body)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response triggerCrawler(List<String> seedUrls) {
        if (seedUrls == null || seedUrls.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No seeds provided").build();
        }

        System.out.println("API: Crawler triggered with seeds: " + seedUrls);

        // Running in background thread so API doesn't hang
        new Thread(() -> {
            Crawler crawler = new Crawler();
            crawler.startCrawling(seedUrls);
        }).start();

        return Response.accepted("Crawler started.").build();
    }
}