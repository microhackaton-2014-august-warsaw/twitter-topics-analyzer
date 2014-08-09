package pl.microhackaton.analyzer.twitter.topics;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.ofg.infrastructure.discovery.ServiceResolver;
import com.ofg.infrastructure.discovery.util.MicroDepsService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.codehaus.jackson.annotate.JsonMethod;
import pl.microhackaton.analyzer.twitter.topics.filter.CorrelationIdFilter;
import pl.microhackaton.analyzer.twitter.topics.healthcheck.PingCheck;
import pl.microhackaton.analyzer.twitter.topics.resources.PairIdController;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

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
        final MicroDepsService microDepsService = configuration.getMicroDepServiceConfiguration().build(environment);
        final ServiceResolver serviceResolver = microDepsService.getServiceResolver();
        environment.jersey().register(new PairIdController(serviceResolver));

        // add correlation id filter
        environment.servlets().addFilter("CorrelationIdFilter", new CorrelationIdFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");


        environment.healthChecks().register("ping", new PingCheck());

        environment.getObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        environment.getObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    public static void main(String[] args) throws Exception {
        new TwitterTopicsAnalyzerApplication().run(args);
    }
}
