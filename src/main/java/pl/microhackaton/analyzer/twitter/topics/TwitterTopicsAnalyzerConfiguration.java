package pl.microhackaton.analyzer.twitter.topics;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import pl.microhackaton.analyzer.twitter.topics.managed.MicroDepServiceConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by pmasko on 09.08.2014.
 */
public class TwitterTopicsAnalyzerConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("microDepServiceConfiguration")
    MicroDepServiceConfiguration microDepServiceConfiguration;

    public MicroDepServiceConfiguration getMicroDepServiceConfiguration() {
        return microDepServiceConfiguration;
    }

    public void setMicroDepServiceConfiguration(MicroDepServiceConfiguration microDepServiceConfiguration) {
        this.microDepServiceConfiguration = microDepServiceConfiguration;
    }

}
