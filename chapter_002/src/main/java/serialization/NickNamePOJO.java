package serialization;

public class NickNamePOJO {
    private final String nick;


    public NickNamePOJO(String nicks) {
        this.nick = nicks;

    }

    public String getNick() {
        return nick;
    }



    @Override
    public String toString() {
        return "NickName{"
                + "nick='" + nick + '\''
                + '}';
    }
}
