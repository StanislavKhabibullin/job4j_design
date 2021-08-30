package solid.ocp.example2;

public class CorrectKitcheAppliancies {

    public interface FoodApp {
      String food();
    }

    public static class Refrigerator implements FoodApp {
        @Override
        public String food() {
            return "save";
        }
    }

    public static class KitchenStove implements FoodApp {
        @Override
        public String food() {
            return "cooking food";
        }
    }

}