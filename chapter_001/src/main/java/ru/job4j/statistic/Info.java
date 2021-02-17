package ru.job4j.statistic;

public class Info {
    int aded = 0;
    int changed = 0;
    int deleted = 0;

    @Override
    public String toString() {
        return "Info{" +
                "aded=" + aded
                + ", changed=" + changed
                + ", deleted=" + deleted
                + '}';
    }
}
