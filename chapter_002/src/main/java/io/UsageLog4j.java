package io;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UsageLog4j {
    private static final Logger LOG;

    static {
        LOG = LogManager.getLogger(UsageLog4j.class.getName());
    }

    public static void main(String[] args) {
        LOG.trace("Trace manager");
        LOG.debug("Debug manager");
        LOG.info("Info manager");
        LOG.warn("Warn manager");
        LOG.error("Error manager");
    }
}