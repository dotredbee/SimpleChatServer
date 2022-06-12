package org.moremore.simplechatserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Transport {
    private final InputStream is;
    private final OutputStream os;

    private Transport(InputStream is, OutputStream os) {
        this.is = is;
        this.os = os;
    }

    public static Transport of(InputStream is, OutputStream os) {
        return new Transport(Objects.requireNonNull(is),
                            Objects.requireNonNull(os));
    }

    public void send(String msg) throws IOException {
        byte[] bytes = msg.getBytes();

        os.write(bytes);
        os.flush();
    }

    public String recv() throws IOException {
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        return bytesToString(bytes, len);
    }

    public String bytesToString(byte[] bytes, int len) {
        return new String(bytes, 0, len, StandardCharsets.UTF_8);
    }

    public void close() throws IOException {
        if(!Objects.isNull(is)) is.close();
        if(!Objects.isNull(os)) os.close();
    }
}
