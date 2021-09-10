package solid.lsp.example2;

public class UsedBelTractor extends UsedTractor {
    public UsedBelTractor(int engineHours, float price, float pecentage) {
        super(engineHours, price, pecentage);
    }

    @Override
    public int getEngineHours() {
        return super.getEngineHours();
    }

    @Override
    public void setEngineHours(int engineHours) {
        super.setEngineHours(engineHours);
    }

    @Override
    public float getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(float price) {
        super.setPrice(price);
    }

    @Override
    public float getPecentage() {
        return super.getPecentage();
    }

    @Override
    public void setPecentage(float pecentage) {
        super.setPecentage(pecentage);
    }

    @Override
    float getPriceFutureUsage() {
        int residualMotorLife = 1_000_000 - engineHours; // пропустили условие при котором метод выдает
        float result = price / residualMotorLife;        // исключение что приобретаемая техника мусор
        return result;
    }
}
