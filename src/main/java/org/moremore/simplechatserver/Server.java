package org.moremore.simplechatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Vector;

public class Server {
    private final ServerSocket serverSocket;

    private Server() throws IOException {
        serverSocket = new ServerSocket(5001);
        accept();
    }

    public static Server start() throws IOException{
        return new Server();
    }

    private void accept() throws IOException {
        assert !Objects.isNull(serverSocket);

        while(true){
            Socket socket = serverSocket.accept();
            Client client = Client.of(socket);

            String request = client.recv();

            System.out.println(request);
        }
    }

    @Override
    public String toString(){
        return serverSocket.toString();
    }
}
