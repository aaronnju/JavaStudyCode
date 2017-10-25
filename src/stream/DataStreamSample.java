package stream;

import java.io.*;

/**
 * Created by shuming.wang on 2016-9-25.
 */
public class DataStreamSample {
    public static void main(String[] args) throws Exception
    {
        writeDemo();
        readDemo();
    }

    public static void readDemo() throws IOException
    {
        DataInputStream dos = new DataInputStream(new FileInputStream("C:/in.txt"));
        String s = dos.readUTF();
        System.out.println(s);
    }

    public static void writeDemo() throws IOException
    {
        /*
         * DataOutputStream(OutputStream out)
         * Creates a new data output stream to write data to the specified underlying output stream.
        */
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/in.txt"));
        /*
         * writeUTF(String str)
         * Writes a string to the underlying output stream using modified UTF-8 encoding in a machine-independent manner.
        */
        dos.writeUTF("你好啊");//UTF-8修改版
    }
}
