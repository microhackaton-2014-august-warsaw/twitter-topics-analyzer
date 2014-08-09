package pl.microhackaton.analyzer.twitter.topics.model;

public class TopicInfo {

	private Topic topic;
	private TopicOrigin origin;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public TopicOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(TopicOrigin origin) {
		this.origin = origin;
	}
}
