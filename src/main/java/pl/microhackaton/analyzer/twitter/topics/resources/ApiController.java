package pl.microhackaton.analyzer.twitter.topics.resources;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ofg.infrastructure.discovery.ServiceResolver;
import pl.microhackaton.analyzer.twitter.topics.model.AnalyzeTweetsRequest;
import pl.microhackaton.analyzer.twitter.topics.model.Tweet;
import pl.microhackaton.analyzer.twitter.topics.service.AnalyzeRunner;

import com.codahale.metrics.annotation.Timed;

/**
 * Created by pmasko on 09.08.2014.
 */
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiController {

    private final ServiceResolver serviceResolver;

    public ApiController(ServiceResolver serviceResolver) {
        this.serviceResolver = serviceResolver;
    }

    @GET
	@Timed
	@Path("/hello/{name}")
	public String getHello(@PathParam("name") String name) {
		return "{\"hello\" : \"" + name + "\"}";
	}

	@POST
	@Timed
	@Path("/hello2/{name}")
	public String postGello(String name) {
		return getHello(name);
	}

	@POST
	@Timed
	@Path("/tweets/{twitterLogin}/{pairId}")
	public String analyze(Set<Tweet> tweets,
			@PathParam("twitterLogin") String twitterLogin,
			@PathParam("pairId") Long pairId) throws InterruptedException,
			ExecutionException, TimeoutException {
		AnalyzeTweetsRequest request = new AnalyzeTweetsRequest();
		request.setTweets(tweets);
		request.setTwitterLogin(twitterLogin);
		request.setPairId(pairId);

		AnalyzeRunner analyzer = new AnalyzeRunner(request, null);
		Executors.newCachedThreadPool().submit(analyzer);

		return "{}";
	}

}
