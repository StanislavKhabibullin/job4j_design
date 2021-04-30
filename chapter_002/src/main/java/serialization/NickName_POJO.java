package serialization;

public class NickName_POJO {
    private final String nick;


    public NickName_POJO(String nicks) {
        this.nick = nicks;

    }

    public String getNick() {
        return nick;
    }



    @Override
    public String toString() {
        return "NickName{" +
                "nick='" + nick + '\'' +
                '}';
    }
}
