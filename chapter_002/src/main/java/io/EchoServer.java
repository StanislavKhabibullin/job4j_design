package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8000)){   //Создаем сервер адрес - localhost, порт - 9000
            while (!server.isClosed()) {          // сервер работает, пока его принудительно не закроют
                Socket socket = server.accept();  //ожидаем когда к серверу обратиться клиент, программа в режиме ожидания
                try (OutputStream out = socket.getOutputStream();  // выходной поток
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())   // входной поток
                     )){
                    String str;
                    String result = null;
                 /*   while (!(str = in.readLine()).isEmpty()) {     // читаем весь входной поток
                        System.out.println(str);
                        if (str.contains("msg")) {
                            var stroka = str.split("=");
                            var stroka2 = stroka[1].split(" ");
                            result = stroka2[0];
                            System.out.println("result == " + result);
                        }
                    }

                  */

                    out.write("HTTP/1.1 200 OK\r\n\"".getBytes());  // в ответ записываем строку "HTTP/1.1 200 OK\r\n\"" в выходной поток

                 /*  if (result.equals(null)) {
                       server.close();
                   }

                  */
                    server.close();

                }
            }

        }

    }
}
