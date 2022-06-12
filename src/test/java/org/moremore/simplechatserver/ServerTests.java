package org.moremore.simplechatserver;

import org.junit.Test;

import java.io.IOException;

public class ServerTests {
    @Test
    public void startServerTest(){
        try{
            Server server1 = Server.start();
            System.out.println(server1.toString());

            Server server2 = Server.start();

            System.out.println(server1.equals(server2));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
