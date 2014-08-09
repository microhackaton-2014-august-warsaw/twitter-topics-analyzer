package pl.microhackaton.analyzer.twitter.topics.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rafal on 09.08.14.
 */
public class TweetTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void tweetsShoudBeMappedFromJsonToSet() throws Exception {
        //given
        URL tweetsStream = getClass().getResource("tweets.json");
        //when
        Set<Tweet> tweets = objectMapper.readValue(tweetsStream, new TypeReference<Set<Tweet>>() {});
        //then
        assertThat(tweets).hasSize(1);
        assertThat(tweets.iterator().next().getEntities().getHashTags()).contains(new HashTag("example_hash_tag"));
    }
}
