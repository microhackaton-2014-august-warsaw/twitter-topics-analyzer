package pl.microhackaton.analyzer.twitter.topics;

import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TwitterTopicsAnalyzerApplicationTest {

    private final Environment environment = mock(Environment.class);
    private final JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private final TwitterTopicsAnalyzerApplication application = new TwitterTopicsAnalyzerApplication();
    private final TwitterTopicsAnalyzerConfiguration config = new TwitterTopicsAnalyzerConfiguration();

    @Before
    public void setup() throws Exception {
        when(environment.jersey()).thenReturn(jersey);
    }

    @Test
    public void buildsAThingResource() throws Exception {
        application.run(config, environment);
    }

}