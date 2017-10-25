package stream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;

/**
 * Created by shuming.wang on 2016-9-24.
 */
public class ZipStreamSample {
    public static void main(String[] args) throws Exception
    {
        // 定义要压缩的文件
        File file = new File("C:" + File.separator + "in.txt");
        // 定义压缩文件名称
        File zipFile = new File("C:" + File.separator + "in.zip");
        /*
         * FileInputStream(File file)
         * Creates a FileInputStream by opening a connection to an actual file, the file named by the File object file in the file system.
         * 定义文件的输入流
        */
        InputStream input = new FileInputStream(file);
        // 声明压缩流对象
        ZipOutputStream zipOut = null;
        /*
         * ZipOutputStream(OutputStream out)
         * Creates a new ZIP output stream.
         * 再次体现了Java的流函数架构中的"装饰器设计模式"的强大之处，我们可以根据我们对功能的
         * 需要任意组合、加载我们需要的流，用通俗的话来说，把它们层层包裹在一起
        */
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        /*
         * putNextEntry(ZipEntry e)
         * Begins writing a new ZIP file entry and positions the stream to the start of the entry data.
         * 设置ZipEntry对象
        */
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        int temp = 0;
        /*
         * read()
         * Reads a byte of data from this input stream.
         * 从文件流中读取内容
        */
        while((temp = input.read()) != -1)
        {
            // 压缩输出
            zipOut.write(temp);
        }
        // 关闭输入流
        input.close();
        // 关闭输出流
        zipOut.close();


        // read zip file as input stream
        InputStream is= new FileInputStream("C:" + File.separator + "in.zip");
        //zip is read by ZipInputStream
        ZipInputStream zis= new ZipInputStream(is);
        // now write zip file in extracted file
        ZipEntry ze;
        byte[] buff = new byte[1024];
        /*
         * getNextEntry()
         * Reads the next ZIP file entry and positions the stream at the beginning of the entry data.
        */
        while((ze = zis.getNextEntry()) != null)
        {
            // get file name
            FileOutputStream fos= new FileOutputStream("C:" + File.separator + "out.txt");
            int l=0;
            // write buffer to file
            while((l = zis.read(buff)) > 0)
            {
                fos.write(buff,0, l);
            }
        }
        zis.close();
    }
}
