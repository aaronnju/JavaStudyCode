package stream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by shuming.wang on 2016-9-24.
 */
public class FileStreamSample {
    public static void main(String[] args) throws Exception
    {
        File f = new File("C:\\1.txt");
        //向文件里写如"Hello"字符串.
        try
        {
            //要写入的数据转换成字节数组
            byte[] buf = "Hello".getBytes();
            /*
             * FileOutputStream(File file)
             * Creates a file output stream to write to the file represented by the specified File object.
             * 如果1.txt存在,则删除1.txt里面的内容,文本所有内容变为Hello
             * 如果1.txt不存在,在新建1.txt文本,写入Hello
            */
            FileOutputStream out = new FileOutputStream(f);
            /*
             * write(byte[] b)
             * Writes b.length bytes from the specified byte array to this file output stream.
            */
            out.write(buf);
            out.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        //读取文件中的内容
        try
        {
            /*
             * FileInputStream(File file)
             * Creates a FileInputStream by opening a connection to an actual file, the file named by the File object file in the file system.
            */
            FileInputStream in = new FileInputStream(f);
            byte[] buf = new byte[1024];
            /*
             * read(byte[] b)
             * Reads up to b.length bytes of data from this input stream into an array of bytes.
             * 从流中读取内容
            */
            int len = in.read(buf);
            String str = new String(buf,0,len);
            //打印f文件的内容.
            System.out.println(str);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
