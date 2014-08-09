package pl.microhackaton.analyzer.twitter.topics.service;

import pl.microhackaton.analyzer.twitter.topics.model.AnalyzeTweetsRequest;
import pl.microhackaton.analyzer.twitter.topics.model.HashTag;
import pl.microhackaton.analyzer.twitter.topics.model.Topic;
import pl.microhackaton.analyzer.twitter.topics.model.TopicsRequest;
import pl.microhackaton.analyzer.twitter.topics.model.Tweet;

public class AnalyzeRunner implements Runnable {

	private final AnalyzeTweetsRequest tweetsData;

	public AnalyzeRunner(AnalyzeTweetsRequest analyzeTweetsRequest) {
		this.tweetsData = analyzeTweetsRequest;
	}

	@Override
	public void run() {
		TopicsRequest topicsRequest = createTopicsRequest();
		// TODO call correlator
	}

	private TopicsRequest createTopicsRequest() {
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
}
