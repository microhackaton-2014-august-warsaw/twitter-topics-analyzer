package pl.microhackaton.analyzer.twitter.topics.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.microhackaton.analyzer.twitter.topics.model.AnalyzeTweetsRequest;
import pl.microhackaton.analyzer.twitter.topics.service.AnalyzeRunner;

import com.codahale.metrics.annotation.Timed;

/**
 * Created by pmasko on 09.08.2014.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PairIdController {

	@GET
	@Timed
	@Path("/api/hello/{name}")
	public String sayHello(@PathParam("name") String name) {
		return "it works, " + name;
	}

	@POST
	@Timed
	@Path("/api/{pairId}")
	public void analyze(AnalyzeTweetsRequest analyzeTweetsRequest, @PathParam("pairId") String pairId) {
		AnalyzeRunner analyzer = new AnalyzeRunner(analyzeTweetsRequest);
		analyzer.run();
	}

}
