package stream;

import java.io.*;

/**
 * Created by shuming.wang on 2016-9-25.
 */
public class BufferedStreamSample {
    public static void main(String[] args) throws Exception
    {
        File filein = new File("C:/1.png");
        File fileout = new File("C:/out.png");
        try
        {
            //前面说过，File类它不负责数据的输入输出，而专门用来管理磁盘文件与目录
            if (fileout.exists() == false)
            {
                fileout.createNewFile();
            }
            //要使用文件流，自然要使用文件读取流函数
            FileInputStream in = new FileInputStream(filein);
            FileOutputStream out = new FileOutputStream(fileout);
            byte[] b = new byte[1];
            //在文件流外面包一层缓冲流读取函数
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            //缓存读取、缓存写入
            while (bin.read(b) != -1)
            {
                bout.write(b);
            }
            bout.close();
            bin.close();
            out.close();
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
