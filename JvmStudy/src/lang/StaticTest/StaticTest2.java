package lang.StaticTest;

/**
 * Created by shuming.wang on 2017-1-11.
 * 第一段的规则依然有效，只是不健全。
 只有主动请求一个类,这个类才会初始化,仅包含静态变量,函数,等静态的东西.
 继承关系时,先初始化父类,后初始化子类.
 静态变量会按照声明的顺序先依次声明并设置为该类型的默认值,但不赋值为初始化的值.
 声明完毕后,再按声明的顺序依次设置为初始化的值,如果没有初始化的值就跳过.
 当初始化A.b=B.a时,暂停初始化A.b,设置当前类为B,跳到步骤3,并执行.
 当初始化B.plus = new A时,暂停初始化B.plus,实例化A并赋值给B.plus.
 当A的构造函数里需要获得B.a的值时,B.a还初始化并处于暂停初始化状态,直接取B.a的当前值,不再等待B.a初始化.
 final,静态常量其实是遵循普通静态变量的初始化的,但是在编译时,编译器会将不可变的常量值在使用的地方替换掉.可以用Java反编译工具查看.
 */
public class StaticTest2 {
    public static void main(String[] arg)
    {
        System.out.println("main, A.b="+A.b);
        System.out.println("main, B.t="+B.t);
        System.out.println("main, C.a="+C.a);
    }
}
class A
{
    public static int b = B.a;
    public static A plus =new A("A");
    public static final int finalInt = (int)(Math.random()*100);
    public static B p = new B("A");

    public static final String finalStr = "finalStr";
    public static final Integer finalInteger = new Integer(10);
    public static int a = 1;
    public static B c = null;

    public A(String from)
    {
        System.out.println("----------- begin A::A ----------------");
        System.out.println("A::A, from="+from);
        System.out.println("A::A, A.b="+A.b);
        System.out.println("A::A, A.finalInt="+A.finalInt);
        System.out.println("A::A, B.a="+B.a);
        System.out.println("A::A, B.plus="+B.plus);
        System.out.println("----------- end A::A ----------------");
    }
}

class B
{
    public static int t = A.a;
    public static A plus = new A("B");
    public static int a = 1;

    public B(String from)
    {
        System.out.println("----------- begin B::B ----------------");
        System.out.println("B::B, from="+from);
        System.out.println("B::B, B.a="+B.a);
        System.out.println("B::B, A.a="+A.a);
        System.out.println("B::B, A.p="+A.p);
        System.out.println("B::B, A.plus="+A.plus);
        System.out.println("B::B, A.finalInt="+A.finalInt);
        System.out.println("B::B, A.finalInteger="+A.finalInteger);
        System.out.println("B::B, A.finalStr="+A.finalStr);
        System.out.println("----------- end B::B ----------------");
    }
}

class C
{
    public static final A a = new A("C");
}
