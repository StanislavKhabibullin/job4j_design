package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jException {

    public static final Logger LOG = LoggerFactory
            .getLogger(UsageLog4jException.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("Not supported code"); // почему тут может быть исключение
        } catch (Exception e) {
            LOG.error("Exception in log example", e); // объект исключения
        }
    }

}
