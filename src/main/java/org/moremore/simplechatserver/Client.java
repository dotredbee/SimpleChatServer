package org.moremore.simplechatserver;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private final Socket socket;
    private final Transport transport;
    private Client(Socket socket) throws IOException {
        this.socket = socket;
        this.transport = Transport.of(socket.getInputStream(),
                                    socket.getOutputStream());
    }

    public static Client of(Socket socket) throws IOException {
        Objects.requireNonNull(socket);

        return new Client(socket);
    }

    public String recv() throws IOException {
        return transport.recv();
    }

    public void close() {
        try{
            if(!Objects.isNull(transport)) transport.close();
            if(!Objects.isNull(socket)) socket.close();
        }catch (IOException e){ e.printStackTrace();}
    }
    @Override
    public String toString() {
        return this.socket.toString();
    }

}
