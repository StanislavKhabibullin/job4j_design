package solid.dip.example1;

public class AutoConfigurator {
    private Transmition transmition;
    private Engine engine;
    private WheelDisks wheelDisks;
    public void chooseModel(Transmition tr, Engine eng, WheelDisks wheels) {
        System.out.println("recomended model auto is - ");
    }
    /*
    В данном классе нарушается принцип DIP в связи с тем, что реализация класса Конфигуратора авто прописана
    жестко, не через интерфейсы
    для того, чтобы исправить ошибку необходимо прописать интерфейсы как для конфигуратора, так и для каждого класса
    Transmition, Engine, WheelDisks
     */
}
