package stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by shuming.wang on 2016-9-25.
 */
public class FileReaderWriterSample {
    public static void main(String[] args) throws Exception
    {
        /*
         * FileReader(String fileName)
         * Creates a new FileReader, given the name of the file to read from.
        */
        Reader reader = new FileReader("C:/in.txt");
        int data = reader.read();
        while(data != -1)
        {
            char theChar = (char) data;
            System.out.print(theChar);
            data = reader.read();
        }
        reader.close();


        Writer writer = new FileWriter("C:/out.txt");
        writer.write("Hello World");
        writer.close();
    }
}
