package io;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConfigTest {

    @Test
    public void WhenPairWithOutComment() {
        String path = "WhenPairWithOutComment.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"),
                is("Petr Arsentiev "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenPairWithOutCommentException() {
        String path = "WhenPairWithOutComment.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name5"),
                is("Lion Arsentiev"));
    }

}