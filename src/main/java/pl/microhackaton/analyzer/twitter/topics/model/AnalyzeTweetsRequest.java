package pl.microhackaton.analyzer.twitter.topics.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rafal on 09.08.14.
 */
public class AnalyzeTweetsRequest {

	@JsonProperty
    private String twitterLogin;
	@JsonProperty
    private Long pairId;
	@JsonProperty
    private Set<Tweet> tweets;

    public String getTwitterLogin() {
        return twitterLogin;
    }

    public void setTwitterLogin(String twitterLogin) {
        this.twitterLogin = twitterLogin;
    }

    public Long getPairId() {
        return pairId;
    }

    public void setPairId(Long pairId) {
        this.pairId = pairId;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }
}
