package gc;

import java.util.ArrayList;
import java.util.List;
import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class GcUser {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory);
        System.out.printf("Total: %d%n", totalMemory);
        System.out.printf("Max: %d%n", maxMemory);
    }

    public static void main(String[] args) {
        System.out.println("свободная память " + (Runtime.getRuntime().freeMemory()));
        info();
        String s = null;
        User userEmpty = new User();
        User user1 = new User(0, 0);
        System.out.println("Первоначальный размер объекта User " + String.valueOf(sizeOf(user1)));
        for (int i = 0; i < 15000; i++) {
          user1 = new User(98765432 + i, 153.4 + i);
           System.out.println("размер объекта User " + String.valueOf(sizeOf(user1)));
        }
        info();
        Integer bigint = 0;
        EmptyObject testObject = new EmptyObject();

        System.out.println("свободная память  в конце программаы " + (Runtime.getRuntime().freeMemory()));
        System.out.println("Вес пустого объекта - " + sizeOf(testObject));
        System.out.println("Просто путой объект - " + testObject);

    }
}
