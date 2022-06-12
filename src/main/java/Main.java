import org.moremore.simplechatserver.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Server server = Server.start();
        }catch (IOException e){}
    }
}
