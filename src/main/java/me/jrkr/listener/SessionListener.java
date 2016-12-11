package me.jrkr.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public final class SessionListener implements HttpSessionListener {

    private static final Logger LOG = LoggerFactory.getLogger(SessionListener.class);

    public static final int SESSION_TIMEOUT_1_MIN = 60;
    public static final int SESSION_TIMEOUT_5_MIN = 5 * SESSION_TIMEOUT_1_MIN;
    public static final int SESSION_TIMEOUT_15_MIN = 3 * SESSION_TIMEOUT_5_MIN;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOG.debug("==== Session is created ====");
        httpSessionEvent.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_1_MIN);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOG.debug("==== Session is destroyed ====");
    }
}
