package pl.microhackaton.analyzer.twitter.topics.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by pmasko on 09.08.2014.
 */
public class PingCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy("pong");
    }
}
