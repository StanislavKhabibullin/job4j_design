package io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UsageLog4j {
    private static final Logger LOG=LoggerFactory
                .getLogger(UsageLog4j.class.getName());


    public static void main(String[] args) {
        LOG.trace("Trace manager");
        LOG.debug("Debug manager");
        LOG.info("Info manager");
        LOG.warn("Warn manager");
        LOG.error("Error manager");
    }
}