package gc;

public class User {
    private String userName = null; // заголовок 8 байт + (3 поля int = 12 байт) + (ссылочная переменна
                             // на объект массива = 4 байта)
                             // + 12 байт на объект массива + 2 байта на каждый объект строки
    private int BilNumber; // 4 байта
    private double sumMoney; // 8 байт

    public User(int bilNumber, double sumMoney) {
        this.userName = "f";
        BilNumber = bilNumber;
        this.sumMoney = sumMoney;
    }

    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("info deleting %d %f.2 %n", BilNumber, sumMoney);
           }

   /* public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    */

    public long getBilNumber() {
        return BilNumber;
    }

    public void setBilNumber(int bilNumber) {
        BilNumber = bilNumber;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", BilNumber=" + BilNumber +
                ", sumMoney=" + sumMoney +
                '}';
    }
}
