package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)){   //Создаем сервер адрес - localhost, порт - 9000
            while (!server.isClosed()) {          // сервер работает, пока его принудительно не закроют
                Socket socket = server.accept();  //ожидаем когда к серверу обратиться клиент, программа в режиме ожидания
                try (OutputStream out = socket.getOutputStream();  // выходной поток
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())   // входной поток
                     )){
                    boolean excited = false;
                    for (String line = in.readLine(); line != null && line.isEmpty();) {
                        if (line.contains("Exit")) {
                            excited = true;
                        }
                    }
                   /* while (!((str = in.readLine()).isEmpty())) {     // читаем весь входной поток
                        System.out.println(str);
                        if (str.contains("msg")) {
                            var stroka = str.split("=");
                            var stroka2 = stroka[1].split(" ");
                            result = stroka2[0];
                            System.out.println("result == " + result);
                        } else {


                           out.write("There is no message".getBytes());
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\"".getBytes());  // в ответ записываем строку "HTTP/1.1 200 OK\r\n\"" в выходной поток
                    out.write("Hellow dear friends".getBytes());
                 /*  if (result.equals(null)) {
                       server.close();
                   }

                  */

                    out.write("HTTP/1.1 200 OK\r\n\"".getBytes());  // в ответ записываем строку "HTTP/1.1 200 OK\r\n\"" в выходной поток
                    out.write("<h2>Hellow dear friends<h2>".getBytes());
                    if (excited) {
                        server.close();
                    }

                }
            }

        }

    }
}
