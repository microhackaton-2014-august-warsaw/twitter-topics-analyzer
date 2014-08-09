package pl.microhackaton.analyzer.twitter.topics.service;

import javax.ws.rs.core.MediaType;

import pl.microhackaton.analyzer.twitter.topics.model.AnalyzeTweetsRequest;
import pl.microhackaton.analyzer.twitter.topics.model.HashTag;
import pl.microhackaton.analyzer.twitter.topics.model.Topic;
import pl.microhackaton.analyzer.twitter.topics.model.TopicsRequest;
import pl.microhackaton.analyzer.twitter.topics.model.TopicsResponse;
import pl.microhackaton.analyzer.twitter.topics.model.Tweet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AnalyzeRunner implements Runnable {

	private final AnalyzeTweetsRequest analyzeTweetsRequest;

	public AnalyzeRunner(AnalyzeTweetsRequest analyzeTweetsRequest) {
		this.analyzeTweetsRequest = analyzeTweetsRequest;
	}

	@Override
	public void run() {
		TopicsRequest request = createTopicsRequest(this.analyzeTweetsRequest);
		TopicsResponse response = callCommonTopicsCorellator(request);
	}

	/**
	 * 
	 * @param tweetsData
	 * @return topics from tweetsData tweets
	 */
	TopicsRequest createTopicsRequest(AnalyzeTweetsRequest tweetsData) {
		TopicsRequest topicsData = new TopicsRequest();
		topicsData.setAnalyzedId(tweetsData.getTwitterLogin());
		for (Tweet tweet : tweetsData.getTweets()) {
			for (HashTag tag : tweet.getEntities().getHashTags()) {
				Topic topic = new Topic(tag.getText());
				topicsData.getTopics().add(topic);
			}
		}
		return topicsData;
	}

	private TopicsResponse callCommonTopicsCorellator(TopicsRequest request) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/aaa/"
				+ request.getPairId());

		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class,
						request);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		return response.getEntity(TopicsResponse.class);
	}

}
