package pl.microhackaton.analyzer.twitter.topics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 {
    "pairId": 1,
    "correlatorType": "topic",
    "relationships": [
        {
            "score": 10,
            "description": "Groovy"
        },
        {
            "score": 2,
            "description": "JavaScript"
        }
    ]
}
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class TopicsResponse {
	
	private long pairId;
	// TODO

	public long getPairId() {
		return pairId;
	}

	public void setPairId(long pairId) {
		this.pairId = pairId;
	}
}
