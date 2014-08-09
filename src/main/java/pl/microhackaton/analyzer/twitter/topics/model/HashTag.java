package pl.microhackaton.analyzer.twitter.topics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import com.google.common.hash.HashCode;

/**
 * Created by rafal on 09.08.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HashTag {

    private String text;

    public HashTag() {
    }

    public HashTag(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }

    @Override
    public boolean equals(Object obj) {
        HashTag that = (HashTag) obj;
        return Objects.equal(text, that.text);
    }
}
