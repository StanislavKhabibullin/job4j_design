package io.exam;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredicateSearch {
public boolean poisk(Path file, String varik, String meaning) {
    if (varik.equals("mask")) {
        var mik = meaning.split("\\.");
        meaning = "." + mik[1];
        var fileName = file.toAbsolutePath().toString();
        return fileName.contains(meaning);
    }
    if (varik.equals("fileName")) {
        var fileName = file.getFileName().toString();
        var result = fileName.equals(meaning);
        return result;
    }
    if (varik.equals("RegEx")) {
        Pattern pattern = Pattern.compile(meaning);
        Matcher matcher = pattern.matcher(file.toAbsolutePath().toString());
        return matcher.find();
    }
    return false;
}
}
