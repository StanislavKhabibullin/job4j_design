package io.exam;

public class PredicateSearch {
public String poisk(String varik, String meaning) {
    if (varik.equals("mask")) {
        var mik = meaning.split("\\.");
        meaning = "." + mik[1];
        return meaning;
    }
    if (varik.equals("fileName")) {
        return meaning;
    }
    if (varik.equals("RegEx")) {
        var mik = meaning.split("\\.");
        meaning = "." + mik[1];
        return meaning;
    }
    return null;
}
}
