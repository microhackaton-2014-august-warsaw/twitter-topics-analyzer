package pl.microhackaton.analyzer.twitter.topics.resources.model;

import java.util.List;

public class TopicsResponse {

	private long pairId;
	private List<TopicInfo> topics;

	public long getPairId() {
		return pairId;
	}

	public void setPairId(long pairId) {
		this.pairId = pairId;
	}

	public List<TopicInfo> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicInfo> topics) {
		this.topics = topics;
	}
}
