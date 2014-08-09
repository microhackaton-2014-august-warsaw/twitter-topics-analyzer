package pl.microhackaton.analyzer.twitter.topics.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pmasko on 09.08.2014.
 */
@Path("/api/{pairId}")
public class PairIdController {

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello(@PathParam("pairId") String pairId) {
        return "it works!";
    }

}
