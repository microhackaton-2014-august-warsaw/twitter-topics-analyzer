package pl.microhackaton.analyzer.twitter.topics.filter;

/**
 * Copy from https://raw.githubusercontent.com/4finance/micro-infra-spring/master/src/main/groovy/com/ofg/infrastructure/web/filter/correlationid/CorrelationIdHolder.groovy
 */
class CorrelationIdHolder {
    static final String CORRELATION_ID_HEADER = "correlationId";
    private static final ThreadLocal<String> id = new ThreadLocal<String>();

    static void set(String correlationId) {
        id.set(correlationId);
    }

    static String get() {
        return id.get();
    }

    static void remove() {
        id.remove();
    }
}