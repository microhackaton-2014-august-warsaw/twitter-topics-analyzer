package pl.microhackaton.analyzer.twitter.topics.service;

import pl.microhackaton.analyzer.twitter.topics.model.AnalyzeTweetsRequest;

public class AnalyzeRunner implements Runnable {

	private final AnalyzeTweetsRequest analyzeTweetsRequest;

	public AnalyzeRunner(AnalyzeTweetsRequest analyzeTweetsRequest) {
		this.analyzeTweetsRequest = analyzeTweetsRequest;
	}

	@Override
	public void run() {
		// TODO analyzeTweetsRequest > topicsRequest > correlator
	}
}
