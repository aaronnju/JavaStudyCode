package stream;

import java.io.*;

/**
 * Created by shuming.wang on 2016-9-25.
 */
public class ObjectStreamSample {


    static class People implements Serializable {
        //必须实现Serializable接口
        int id;
        String name;

        People(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "id:" + id + " name:" + name;
        }
    }

    public static void main(String[] args) throws Exception
    {
        FileOutputStream fop = new FileOutputStream("C:/out.txt");
        /*
         * ObjectOutputStream(OutputStream out)
         * Creates an ObjectOutputStream that writes to the specified OutputStream.
        */
        ObjectOutputStream oos = new ObjectOutputStream(fop);
        People p = new People(1,"zhang");
        /*
         * writeObject(Object obj)
         * Write the specified object to the ObjectOutputStream.
        */
        oos.writeObject(p);
        p = new People(2,"li");
        oos.writeObject(p);
        p = new People(3,"zhao");
        oos.writeObject(p);
        //写入三个对象
        oos.close();
        //关闭输出流
        FileInputStream fis=new FileInputStream("C:/out.txt");
        /*
         * ObjectInputStream(InputStream in)
         * Creates an ObjectInputStream that reads from the specified InputStream.
        */
        ObjectInputStream ois = new ObjectInputStream(fis);
        try
        {
            while(true)
            {
                /*
                 * readObject()
                 * Read an object from the ObjectInputStream.
                */
                People p2=(People)ois.readObject();
                System.out.println(p2);
            }
            //没有办法判断文件中对象的数量,所以,只有通过EOFException异常来中断
            //或者在写入的时候把所有的对象都放到一个ArrayLis里,这样就不需要判断了
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(EOFException e)
        {
            System.out.println("读取结束");
        }
    }
}
