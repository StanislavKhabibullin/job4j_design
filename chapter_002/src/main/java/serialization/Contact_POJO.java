package serialization;

public class Contact_POJO {
    private final String phone;

    public String getPhone() {
        return phone;
    }

    public Contact_POJO(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
