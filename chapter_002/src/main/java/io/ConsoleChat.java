package io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswer;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        writeDataInFile(botAnswer, "UserMessage: " + res);
        boolean scratch = true;
        while (!res.equals(OUT)) {
            if (res.equals(STOP)) {
                System.out.println("User input STOP");
                scratch = false;
            }
            if (res.equals(CONTINUE)) {
                System.out.println("User input continue");
                scratch = true;
            }

            if (scratch) {
                var answer = readFile(path);
                System.out.println(answer);
                writeDataInFile(botAnswer, "BotAnswer: " + answer);
            }
            res = in.nextLine();
            writeDataInFile(botAnswer, "UserMessage: " + res);
        }
        in.close();

    }

    public String readFile(String path) {
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
        Random random = new Random();
        int index = random.nextInt(result.length);
        return result[index];
    }

    public void writeDataInFile(String path, String data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))){
            br.write(data + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/text.txt", "./src/data/textLog.txt");
        cc.run();
    }
}
