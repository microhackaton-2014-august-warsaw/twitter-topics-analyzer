package pl.microhackaton.analyzer.twitter.topics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Created by rafal on 09.08.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {

	@JsonProperty
    private String text;
	@JsonProperty
    private Entity entities;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Entity getEntities() {
        return entities;
    }

    public void setEntities(Entity entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("text", text)
                .add("entities", entities)
                .toString();
    }
}
