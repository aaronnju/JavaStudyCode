package stream;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * Created by shuming.wang on 2016-9-25.
 * printwriter是向文本输出流打印对象的格式化表示形式，它允许以一种格式化的方式进行数据流的写入，类似C语言中的printf()函数
 */
public class PrintWriterSample {
    public static void main(String[] args) throws Exception
    {
        String filename = "C:/out.txt";
        /*
         * PrintWriter(Writer out)
         * Creates a new PrintWriter, without automatic line flushing.
        */
        PrintWriter pw = new PrintWriter(new FileWriter(filename));
        String[] words = new String[]{"hello", "world", "!"};

        for (int i = 0; i < words.length; i++)
        {
            /*
             * format(String format, Object... args)
             * Writes a formatted string to this writer using the specified format string and arguments.
            */
            pw.format("words: %s\n", words[i]);
        }
        /*
         * flush()
         * Flushes the stream.
        */
        pw.flush();
    }
}
