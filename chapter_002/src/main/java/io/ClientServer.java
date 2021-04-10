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
       // out.write(64);
        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        out.write("<h2> Hello dear friends <h2>".getBytes());
        out.flush();

        clientSocket.close();
        socket.close();
    }
}
