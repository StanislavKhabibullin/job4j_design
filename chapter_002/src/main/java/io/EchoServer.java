package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static final Logger LOG = LoggerFactory
            .getLogger(EchoServer.class.getName());

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(9000)) {   //Создаем сервер адрес - localhost, порт - 9000
            while (!server.isClosed()) {          // сервер работает, пока его принудительно не закроют
                Socket socket = server.accept();  //ожидаем когда к серверу обратиться клиент, программа в режиме ожидания
                try (OutputStream out = socket.getOutputStream();  // выходной поток
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())   // входной поток
                     )) {
                    boolean excited = false;
                    boolean isRead = false;
                    String text = "";
                    for (String line = in.readLine(); line != null && !line.isEmpty(); line = in.readLine()) {
                        if (line.contains("Exit")) {
                            excited = true;
                        }
                        isRead = true;
                        if (line.contains("?msg=")) {
                            text = text + line;
                        }
                    }
                    if (isRead) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("<h2>Hello dear friends<h2>".getBytes());
                        //server.close();
                        if (excited) {
                            out.write("\n".getBytes());
                            out.write("User write Exit".getBytes());
                            server.close();
                        }
                        var result = text.split(" ");
                        var finResult = result[1].split("=");
                        out.write("\n".getBytes());
                        out.write(finResult[1].getBytes());
                    }


                }
            }

        } catch (IOException e) {
           LOG.error("Error input", e);
        }

    }

    }


