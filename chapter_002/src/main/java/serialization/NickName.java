package serialization;

import java.util.Arrays;

public class NickName {
    private final String nick;
    private final int age;

    public NickName(String nicks, int age) {
        this.nick = nicks;
        this.age = age;
    }

    @Override
    public String toString() {
        return "NickName{" +
                "nick='" + nick + '\'' +
                ", age=" + age +
                '}';
    }
}
