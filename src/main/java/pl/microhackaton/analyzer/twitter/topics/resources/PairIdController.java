package pl.microhackaton.analyzer.twitter.topics.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by pmasko on 09.08.2014.
 */
@Path("/api/{pairId}")
public class PairIdController {

    @GET
    @Timed
    @ExceptionMetered
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String sayHello(@PathParam("pairId") String pairId) {
        return "it works!";
    }

}
