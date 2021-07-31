package cache;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emulator {
    public static void showMenu() {
        List<String> questions = new ArrayList<>();
        questions.add("Please, choose what do you want to do:");
        questions.add("Input cache directory");
        questions.add("Input fileName");
        questions.add("Load file content into cache");
        questions.add("Get file content from cache");
        questions.add("Quit");
        for (int i = 0; i < questions.size(); i++) {
            if (i != 0 ) {
                System.out.println(i + " ." + questions.get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        showMenu();
        String initialDirectory = "C:\\projects\\job4j_design\\chapter_004";
        AbstractCache<String, String> abstractCache = new DirFileCache(initialDirectory);
       // DirFileCache test = new DirFileCache(initialDirectory);
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        String fileName = null;
        int choice = in.nextInt();
        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    System.out.println("Input cache directory");
                    String dir = inStr.nextLine();
                   // test = new DirFileCache(dir);
                    abstractCache = new DirFileCache(dir);

                case 2:
                    System.out.println("Input fileName");
                    fileName = inStr.nextLine();
                    System.out.println(fileName);
                    break;
                case 3:
                    System.out.println("input content for " + fileName);
                    String content = inStr.nextLine();
                   // test.put(fileName, content);
                    abstractCache.put(fileName, content);
                    break;

                case 4:
                    System.out.println("content from " + fileName + " is:");
                   // String result = test.get(fileName);
                    String result = abstractCache.load(fileName);
                    System.out.println(result);
                    break;
                default:
                    System.out.println("Nice to meet you");
            }
            showMenu();
            choice = in.nextInt();
        }
        System.out.println("finish");
    }
}
