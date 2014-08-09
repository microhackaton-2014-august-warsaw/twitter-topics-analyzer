package pl.microhackaton.analyzer.twitter.topics;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by pmasko on 09.08.2014.
 */
public class TwitterTopicsAnalyzerApplication  extends Application<TwitterTopicsAnalyzerConfiguration> {
    @Override
    public String getName() {
        return "TwitterTopicsAnalyzer";
    }

    @Override
    public void initialize(Bootstrap<TwitterTopicsAnalyzerConfiguration> bootstrap) {

    }

    @Override
    public void run(TwitterTopicsAnalyzerConfiguration configuration, Environment environment) throws Exception {

    }

    public static void main(String[] args) throws Exception {
        new TwitterTopicsAnalyzerApplication().run(args);
    }
}
