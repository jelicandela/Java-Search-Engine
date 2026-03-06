package SearchEngine;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
public class AdminResource {

    
	@GET
    @Path("/spam-reports")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpamReports() {
        System.out.println("API: Fetching real spam reports...");
 
        List<String> realList = SpamList.getInstance().getBlockedList();
        
        return Response.ok(realList).build();
    }

    @DELETE
    @Path("/spam-strategy/{id}")
    public Response removeSpamEntry(@PathParam("id") String urlId) {
        System.out.println("API: Unblocking URL: " + urlId);
        SpamList.getInstance().unblockUrl(urlId);
        return Response.ok("URL unblocked/removed.").build();
    }

    @PUT
    @Path("/spam-strategy")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response setSpamStrategy(String strategyName) {
        System.out.println("API: Changing spam strategy to: " + strategyName);
        
        if ("strict".equalsIgnoreCase(strategyName)) {
            Index.getInstance().setSpamBehavior(new IsSpammed());
        } else {
            Index.getInstance().setSpamBehavior(new SpamFilter());
        }
        return Response.ok("Strategy updated.").build();
    }
}