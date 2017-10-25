package lang.StaticTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shuming.wang on 2017-1-11.
 * Java静态变量初始化遵循以下规则:
 静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
 声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过。
 看了这个就会明白,原来Test.a的值变化了三次。
 声明时设置为0>>Test1::Test1里设置为1>>Test.a初始化为0
 */

public class StaticTest1
{
    static{
        System.out.println("StaticTest1Static enter");
    }

    public static Test1 t = new Test1();
    public static int a = 0;
    public static int b;
    static{
        System.out.println("StaticTest1Static");
    }

    public static void main(String[] arg)
    {
        System.out.println("main1");
        System.out.println(StaticTest1.a);
        System.out.println(StaticTest1.b);
    }
}

class Test1
{
    public Test1()
    {
        System.out.println("Test1");
        StaticTest1.a++;
        StaticTest1.b++;
        System.out.println(""+ StaticTest1.a +"," +StaticTest1.b);
    }
}
