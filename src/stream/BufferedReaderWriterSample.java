package stream;
import java.io.*;

/**
 * Created by shuming.wang on 2016-9-25.
 * 和BufferedInputStream、BufferedOutputStream不同的是，
 * BufferedReader、BufferedWriter提供了ReadLine、newLine()这种以行为单位的字符读写机制
 */
public class BufferedReaderWriterSample {
    public static void main(String[] args) throws Exception
    {
        /*
         * FileReader(String fileName)
         * Creates a new FileReader, given the name of the file to read from.
        */
        Reader reader = new FileReader("C:/in.txt");
        /*
         * BufferedReader(Reader in)
         * Creates a buffering character-input stream that uses a default-sized input buffer.
         * 在Reader之上再包一层Buffer缓冲区的功能
        */
        BufferedReader brd = new BufferedReader(reader);

        String data = brd.readLine();
        while(data != null)
        {
            System.out.print(data);
            data = brd.readLine();
        }
        brd.close();
        reader.close();


        Writer writer = new FileWriter("C:/out.txt");
        /*
         * BufferedWriter(Writer out)
         * Creates a buffered character-output stream that uses a default-sized output buffer.
        */
        BufferedWriter bwd = new BufferedWriter(writer);
        /*
         * write(String s, int off, int len)
         * Writes a portion of a String.
        */
        bwd.write("Hello World");
        /*
         * newLine()
         * Writes a line separator.
        */
        bwd.newLine();
        bwd.close();
        writer.close();
    }
}
