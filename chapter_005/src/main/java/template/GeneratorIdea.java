package template;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GeneratorIdea implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        boolean trek = true;
        List<String> mas = Arrays.asList(template.split(" "));
        StringBuilder stringBuilder = new StringBuilder();
        for (String word
                :mas) {
            if (args.get(word) != null) {
                word = args.get(word);
                trek = false;
            }
            stringBuilder.append(word).append(" ");
        }
        if (trek) {
            throw new IllegalArgumentException();
        }
        return String.valueOf(stringBuilder);
    }
}
