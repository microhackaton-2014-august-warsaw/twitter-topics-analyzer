package pl.microhackaton.analyzer.twitter.topics.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import pl.microhackaton.analyzer.twitter.topics.model.AnalyzeTweetsRequest;
import pl.microhackaton.analyzer.twitter.topics.service.AnalyzeRunner;

/**
 * Created by pmasko on 09.08.2014.
 */
@Path("/api/{pairId}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PairIdController {

	@GET
	@Timed
	public String sayHello(@PathParam("pairId") String pairId) {
		return "it works!";
	}

	@POST
	@Timed
	public void analyze(AnalyzeTweetsRequest analyzeTweetsRequest) {
		AnalyzeRunner analyzer = new AnalyzeRunner(analyzeTweetsRequest);
		analyzer.run();
	}

}
