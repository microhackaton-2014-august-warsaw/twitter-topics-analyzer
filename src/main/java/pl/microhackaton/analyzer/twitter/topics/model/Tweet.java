package pl.microhackaton.analyzer.twitter.topics.model;

/**
 * Created by rafal on 09.08.14.
 */
public class Tweet {

    private String text;
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
}
