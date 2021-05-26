package io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory
                .getLogger(UsageLog4j.class.getName());


    public static void main(String[] args) {
        LOG.trace("Trace manager");
        LOG.debug("Debug manager");
        LOG.info("Info manager");
        LOG.warn("Warn manager");
        LOG.error("Error manager");
        String name = "Petr Arsentev";
        int age = 33;
        double weight = 88.2;
        char classLetter = 'a';
        long schet = 999999999;
        boolean opinion = true;
        short student = 1954;
        byte bit = 64;
        LOG.debug("User info name : {}, age : {}, weight : {},"
                + "classletter : {}, bankSchetNumber : {},"
                        + "hisPoliticOpinion : {}, studentsQantity : {}, bit : {}",
                name, age, weight, classLetter, schet, opinion, student, bit);
    }
}