package io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9000);
        Socket clientSocket = socket.accept();
        var out = clientSocket.getOutputStream();

        out.write("HTTP/1.1 200 asdfdasa OK\r\n\r\n".getBytes());
       
        out.flush();

        clientSocket.close();
        socket.close();
    }
}
