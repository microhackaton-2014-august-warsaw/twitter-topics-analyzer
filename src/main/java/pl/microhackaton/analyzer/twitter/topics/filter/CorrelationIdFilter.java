package pl.microhackaton.analyzer.twitter.topics.filter;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;


public class CorrelationIdFilter implements javax.servlet.Filter {
    private static final Logger LOG = LoggerFactory.getLogger(CorrelationIdFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        setupCorrelationId((HttpServletRequest)request, (HttpServletResponse)response);

        try {
            filterChain.doFilter(request, response);
        } finally {
            cleanupCorrelationId();
        }
    }

    @Override
    public void destroy() {
    }

    private void setupCorrelationId(HttpServletRequest request, HttpServletResponse response) {
        String correlationIdFrom = getCorrelationIdFrom(request);
        String correlationId = correlationIdFrom != null ? correlationIdFrom : getCorrelationIdFrom(response);

        correlationId = createNewCorrIdIfEmpty(correlationId);

        CorrelationIdHolder.set(correlationId);
        addCorrelationIdToResponseIfNotPresent(response, correlationId);
    }

    private String getCorrelationIdFrom(HttpServletResponse response) {
        return withLoggingAs("response" , response.getHeader(CorrelationIdHolder.CORRELATION_ID_HEADER));
    }

    private String getCorrelationIdFrom(HttpServletRequest request) {
        return withLoggingAs("request", request.getHeader(CorrelationIdHolder.CORRELATION_ID_HEADER));
    }

    private String withLoggingAs(String whereWasFound, String correlationId) {
        if (!Strings.isNullOrEmpty(correlationId)) {
            MDC.put(CorrelationIdHolder.CORRELATION_ID_HEADER, correlationId);
            LOG.debug("Found correlationId in {}: {}", whereWasFound, correlationId);
        }
        return correlationId;
    }

    //TODO: add microservice id to corrId, so that we know where it was created
    private String createNewCorrIdIfEmpty(String currentCorrId) {
        if (!Strings.isNullOrEmpty(currentCorrId)) {
            currentCorrId = UUID.randomUUID().toString();
            MDC.put(CorrelationIdHolder.CORRELATION_ID_HEADER, currentCorrId);
            LOG.info("Generating new correlationId: " + currentCorrId);
        }
        return currentCorrId;
    }

    private void addCorrelationIdToResponseIfNotPresent(HttpServletResponse response, String correlationId) {
        if (!Strings.isNullOrEmpty(response.getHeader(CorrelationIdHolder.CORRELATION_ID_HEADER))) {
            response.addHeader(CorrelationIdHolder.CORRELATION_ID_HEADER, correlationId);
        }
    }

    private void cleanupCorrelationId() {
        MDC.remove(CorrelationIdHolder.CORRELATION_ID_HEADER);
        CorrelationIdHolder.remove();
    }
}
