package template;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    private String template1 = "I am a ${name}, Who are ${subject}?";
    private String template2 = "I am a ${name}, Who are ${subject} and what are your ${profession}?";



    @Test
    public void whenInputWrightArgumentInWrightTemplateThenCorrectResult() {
        Map<String, String> args = new HashMap<>();
        Generator generator = new GeneratorIdea();
        args.put("Petr", "you");
        var res = generator.produce(template1, args);
        assertThat(res, is("I am a Petr, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInputWrongTemplateThenException() {
        Map<String, String> args = new HashMap<>();
        Generator generator = new GeneratorIdea();
        args.put("Petr", "you");
        generator.produce(template2, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInputWrongArgumentThenException() {
        Map<String, String> args = new HashMap<>();
        Generator generator = new GeneratorIdea();
        args.put("Petr", "your dogs age");
        generator.produce(template1, args);
    }

}