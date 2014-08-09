package pl.microhackaton.analyzer.twitter.topics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

/**
 * Created by rafal on 09.08.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    private Set<HashTag> hashTags;

    public Set<HashTag> getHashTags() {
        return hashTags;
    }

    public void setHashTags(Set<HashTag> hashTags) {
        this.hashTags = hashTags;
    }
}
