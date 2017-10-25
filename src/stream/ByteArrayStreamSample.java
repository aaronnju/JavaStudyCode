package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by shuming.wang on 2016-9-24.
 * ByteArrayOutputStream类是在创建它的实例时，程序内部创建一个byte型数组的缓冲区，
 * 然后利用ByteArrayOutputStream和ByteArrayInputStream的实例向数组中写入或读出byte型数据。
 * 在网络传输中我们往往要传输很多变量，我们可以利用ByteArrayOutputStream把所有的变量收集到一起，然后一次性把数据发送出去
 */
public class ByteArrayStreamSample {
    public static void main(String[] args) throws Exception
    {
        int a=0;
        int b=1;
        int c=2;
        /*
         * ByteArrayOutputStream()
         * Creates a new byte array output stream.
        */
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        /*
         * write(int b)
         * Writes the specified byte to this byte array output stream.
        */
        bout.write(a);
        bout.write(b);
        bout.write(c);
        /*
         * toByteArray()
         * Creates a newly allocated byte array.
         * 返回内部保存的临时byte缓存数组
        */
        byte[] buff = bout.toByteArray();
        for(int i=0; i<buff.length; i++)
        {
            System.out.println(buff[i]);
        }
        System.out.println("***********************");
        /*
         * ByteArrayInputStream(byte[] buf)
         * Creates a ByteArrayInputStream so that it uses buf as its buffer array.
        */
        ByteArrayInputStream bin = new ByteArrayInputStream(buff);
        /*
         * read()
         * Reads the next byte of data from this input stream.
        */
        while((b = bin.read()) != -1)
        {
            System.out.println(b);
        }
    }
}
