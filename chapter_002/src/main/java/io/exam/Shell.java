package io.exam;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Shell {
    String result = "";

    public void cd(String path) {
        if (!path.contains("/")) {
            result = result + "/" + path;
        }
        if (path.equals("..")) {
            result = "/";
        }
        if (path.equals("/")) {
            result = result + "/";
        }
        if (path.contains("../")) {
            var resultikk = path.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 2; i < resultikk.length; i++) {
                stringBuilder.append(resultikk[i]);
            }
            result = stringBuilder.toString();
        }

        if (path.contains("/") && !path.contains("../") && !path.equals("/")){
            result = path;
        }
    }

    public String pwd() {
        return result;
    }
}
