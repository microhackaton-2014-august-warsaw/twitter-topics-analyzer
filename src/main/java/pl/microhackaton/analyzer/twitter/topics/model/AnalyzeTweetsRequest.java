package pl.microhackaton.analyzer.twitter.topics.model;

import java.util.Set;

/**
 * Created by rafal on 09.08.14.
 */
public class AnalyzeTweetsRequest {

    private String twitterLogin;
    private Long pairId;
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
