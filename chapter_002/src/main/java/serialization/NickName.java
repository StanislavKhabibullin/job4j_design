package serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Arrays;

@XmlElement(value = "nickname")

public class NickName {

    @XmlAttribute
    private String nick;

    @XmlAttribute
    private int age;

    public NickName(String nicks, int age) {
        this.nick = nicks;
        this.age = age;
    }

    public NickName() {
    }

    @Override
    public String toString() {
        return "NickName{"
                + "nick='" + nick + '\''
                + ", age=" + age
                + '}';
    }
}
