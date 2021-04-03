package io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswer;
    private final String[] answersList;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
        this.answersList = readFile(path);
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        List<String> userLog = new ArrayList<>();
        userLog.add("UserMessage: " + res + '\n');
        boolean scratch = true;
        while (!res.equals(OUT)) {
            if (res.equals(STOP)) {
                userLog.add("User input STOP" + '\n');
                System.out.println("User input STOP");
                scratch = false;
            }
            if (res.equals(CONTINUE)) {
                userLog.add("User input continue" + '\n');
                System.out.println("User input continue");
                scratch = true;
            }

            if (scratch) {
                Random random = new Random();
                int index = random.nextInt(answersList.length);
                var answer = answersList[index];
                System.out.println(answer);
                userLog.add("BotAnswer: " + answer + '\n');
            }
            res = in.nextLine();
            userLog.add("UserMessage: " + res + '\n');
        }
        in.close();
        writeDataInFile(botAnswer, userLog);
        System.out.println("UserLog contains: ");
        System.out.println(userLog);

    }

    public String[] readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            int data;
            while ((data = br.read()) > 0) {
                builder.append((char) data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        var result = builder.toString().split(" ");
        return result;
    }

    public void writeDataInFile(String path, List<String> data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))){
            for (String stroka:
                 data) {
                br.write(stroka + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/text.txt", "./src/data/textLog.txt");
        cc.run();
    }
}
