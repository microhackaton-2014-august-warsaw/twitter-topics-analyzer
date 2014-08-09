package pl.microhackaton.analyzer.twitter.topics.managed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ofg.infrastructure.discovery.util.MicroDepsService;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Environment;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by pmasko on 09.08.2014.
 */
public class MicroDepServiceConfiguration {

    @NotEmpty
    @JsonProperty
    private String zookeeperUrl;

    @NotEmpty
    @JsonProperty
    private String microserviceContext;

    @NotEmpty
    @JsonProperty
    private String microserviceUrl;

    @Min(1)
    @Max(65535)
    @JsonProperty
    private int microservicePort;

    public MicroDepsService build(Environment environment) {
        final MicroDepsService microDepsService = new MicroDepsService(zookeeperUrl, microserviceContext, microserviceUrl,microservicePort);
        environment.lifecycle().manage(new Managed() {
            @Override
            public void start() throws Exception {
                microDepsService.start();
            }

            @Override
            public void stop() throws Exception {
                microDepsService.start();
            }
        });
        return microDepsService;
    }

}
