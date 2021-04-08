package io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8000);
        Socket clientSocket = socket.accept();
        clientSocket.getOutputStream().write(64);


        socket.close();
    }
}
