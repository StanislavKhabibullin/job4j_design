package solid.isp.taskMenu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RealMenu implements Menu {
    List<Task> taskList = new ArrayList<>();

    @Override
    public void put(Task task) {
        taskList.add(task);

    }

    @Override
    public List<Task> getMenu() {
        for (int i = 0; i < taskList.size(); i++) {
            String taskN = taskList.get(i).taskNumber();
            var numbers = taskN.split("\\.");
            int quantity = numbers.length;
            for (int j = 0; j < quantity; j++) {
                System.out.print("--");
            }
            System.out.println("Task " + taskN);
        }
        return taskList;
    }

    public static void main(String[] args) {
        Task task1 = new RealTask("1.", "info1");
        Task task11 = new RealTask("1.1.", "info1.1");
        Task task111 = new RealTask("1.1.1.", "info1.1.1.");
        Task task2 = new RealTask("2.", "info2");
        Task task3 = new RealTask("3.", "info3");
        Task task31 = new RealTask("3.1.", "info3.1.");
        Menu menu = new RealMenu();
        menu.put(task1);
        menu.put(task11);
        menu.put(task111);
        menu.put(task2);
        menu.put(task3);
        menu.put(task31);
        List<Task> res = menu.getMenu();
        System.out.println("Input task that you want to see: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String input = in.nextLine();
            for (Task vert:
                    res) {
                if (vert.taskNumber().equals(input)) {
                    System.out.println("Task contains this movie - " + vert.internalInfo());
                }
            }
        }



    }
}
