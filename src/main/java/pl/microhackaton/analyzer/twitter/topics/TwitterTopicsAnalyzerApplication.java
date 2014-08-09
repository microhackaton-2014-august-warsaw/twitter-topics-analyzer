package pl.microhackaton.analyzer.twitter.topics;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import pl.microhackaton.analyzer.twitter.topics.healthcheck.PingCheck;
import pl.microhackaton.analyzer.twitter.topics.resources.PairIdController;

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
        environment.jersey().register(new PairIdController());
        environment.healthChecks().register("ping", new PingCheck());
    }

    public static void main(String[] args) throws Exception {
        new TwitterTopicsAnalyzerApplication().run(args);
    }
}
