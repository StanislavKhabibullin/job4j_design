package solid.lsp.example2;

public class UsedTractor {
    int engineHours;
    float price;
    float pecentage;
/**
класс используемый при приобретении б/у тракторов
 */

    public UsedTractor(int engineHours, float price, float pecentage) {
        this.engineHours = engineHours;
        this.price = price;
        this.pecentage = pecentage;
    }

    public int getEngineHours() {
        return engineHours;
    }

    public void setEngineHours(int engineHours) {
        this.engineHours = engineHours;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPecentage() {
        return pecentage;
    }

    public void setPecentage(float pecentage) {
        this.pecentage = pecentage;
    }

    /**
     *  рассчитываем стоимость будущего моточаса трактора
     *  float remainigPowerReserved = 1 - pecentage; // остаток ресурса в %
     * @return
     */
    float getPriceFutureUsage() {
        float remainigPowerReserved = 1 - pecentage;
        if (remainigPowerReserved < 0.3) {
            throw new IllegalArgumentException("This tractor is garbage");
        }
        int residualMotorLife = 1_000_000 - engineHours;
        float result = price / residualMotorLife;
        return result;
    }


}
