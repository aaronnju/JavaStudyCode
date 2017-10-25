package lang.StaticTest;

/**
 * Created by shuming.wang on 2017-1-11.
 * 显示的静态初始化（也就是静态块）
 把多个初始化语句包在一个static花括号里，叫做静态块，其实就是把多个static合在一起写了，本质是一样的。只有首次创建对象或者首次访问类的字段时才会执行，而且仅仅一次。
 */
class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups() {
        System.out.println("Cups()");
    }
}

public class StaticTest4 {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99); // (1)
    }
    // static Cups cups1 = new Cups(); // (2)
    // static Cups cups2 = new Cups(); // (2)
} 