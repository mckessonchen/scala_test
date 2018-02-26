package StreamsTest;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by chenteng on 2017/3/23.
 */

public class streams_test {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteInputStream());
        dis.readUTF();
    }
}
