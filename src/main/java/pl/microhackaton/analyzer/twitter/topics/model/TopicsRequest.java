package pl.microhackaton.analyzer.twitter.topics.model;

import java.util.List;

public class TopicsRequest {

	private static final String DATA_SOURCE = "twitter";

	private long pairId;
	private String analyzerType = DATA_SOURCE;
	private String analyzedId;
	private List<Topic> topics;

	public long getPairId() {
		return pairId;
	}

	public void setPairId(long pairId) {
		this.pairId = pairId;
	}

	public String getAnalyzerType() {
		return analyzerType;
	}

	public void setAnalyzerType(String analyzerType) {
		this.analyzerType = analyzerType;
	}

	public String getAnalyzedId() {
		return analyzedId;
	}

	public void setAnalyzedId(String analyzedId) {
		this.analyzedId = analyzedId;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
}
