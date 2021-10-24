package gc;

public class User {
    /**
     * fields value:
     *  private String userName = null; // заголовок 8 байт + (3 поля int = 12 байт) + (ссылочная переменна
     *                              // на объект массива = 4 байта)
     *                              // + 12 байт на объект массива + 2 байта на каждый объект строки
     *     private int bilnumber; // 4 байта
     *     private double sumMoney; // 8 байт
     */

    private String userName = null;
    private int bilnumber;
    private double sumMoney;

    public User(int bilnumber, double sumMoney) {
        this.userName = "f";
        this.bilnumber = bilnumber;
        this.sumMoney = sumMoney;
    }

    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("info deleting %d %f.2 %n", bilnumber, sumMoney);
           }


    public long getBilnumber() {
        return bilnumber;
    }

    public void setBilnumber(int bilnumber) {
        this.bilnumber = bilnumber;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    @Override
    public String toString() {
        return "User{"
                + "userName='" + userName + '\''
                + ", BilNumber=" + bilnumber
                + ", sumMoney=" + sumMoney
                + '}';
    }
}
