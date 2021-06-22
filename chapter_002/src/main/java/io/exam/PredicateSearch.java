package io.exam;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredicateSearch {
    public Path poisk(Path file, String varik, String meaning) {
        if (varik.equals("mask")) {
            var mik = meaning.split("\\.");
            meaning = "." + mik[1];
            var fileName = file.toAbsolutePath().toString();
            if (fileName.contains(meaning)) {
                return file;
            }
        }
    if (varik.equals("fileName")) {
        var fileName = file.getFileName().toString();
        if (fileName.equals(meaning)) {
          return file;
        }
    }
    if (varik.equals("RegEx")) {
        Pattern pattern = Pattern.compile(meaning);
        Matcher matcher = pattern.matcher(file.toAbsolutePath().toString());
        if (matcher.find()) {
            return file;
        }
    }
        return null;
    }
}
