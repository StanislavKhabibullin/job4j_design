package solid.ocp.example2;

import java.util.List;

public class KitchenAppliancies {

    /**
     * если вместо холодильника мы подставим другой кухонный девайс, например плита, то она служит
     * не для сохранения еды, а для ее приготовления, таким образом наследование здесь не применимо
     * и потребуется вынести метод food в виде интерфейса данный подход реализовал в классе CorrectKitcheAppliancies
     */
    private static class Refrigerator {
        public String food() {
            return "save";
        }
    }

    public static void main(String[] args) {
        List<Refrigerator> refrigerators = List.of(new Refrigerator());
        refrigerators.forEach(app -> app.food());
    }

}
