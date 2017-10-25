/**
 * Created by shuming.wang on 2017-2-7.
 */
public class StringTest {
    Object
    public static void main(String[] args) {
        test1();
        test2();
        test3a();
        test3b();
        System.out.println("end");
        myassert((null instanceof StringTest));
//        myassert(false);
//        System.out.println("end");
    }
    static void myassert(boolean b){
        if (!b)
            throw new AssertionError();
    }

    static void test1(){
        String str1 = "string";
        String str2 = new String("string");
        String str3 = str2.intern();
        myassert(str1!=str2);//#1
        myassert(str1==str3);//#2
    }
    public static void test2() {
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr"+"01";
        myassert(str1 == str2 && str1 == str1.intern());//#3

        String str3 = baseStr + "01";
        myassert(str1 != str3 && str3 != str3.intern());//#4

        String str4 = baseFinalStr+"01";
        myassert(str1 == str4 && str4 == str4.intern());//#5

        String str5 = new String("baseStr01").intern();
        myassert(str1 == str5);//#6
    }
    public static void test3a() {
        String str2 = new String("str")+new String("01");
        str2.intern();
        String str1 = "str01";
        myassert(str2==str1 && str2 == str2.intern());//#7
    }
    public static void test3b() {
        String str1 = "str02";
        String str2 = new String("str")+new String("02");
        str2.intern();
        myassert(str2 != str1 && str2 != str2.intern());//#8
    }

    public static void test11(String[] args) {
        String s = new String("1");
        s.intern();
        System.out.println(s == s.intern());
        String s2 = "1";
        System.out.println(s == s2);
        System.out.println(s.intern() == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
    public static void test12(String[] args) {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);
        System.out.println(s.intern() == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }

    public static void main2(String[] args) {
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr"+"01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr+"01";
        String str5 = new String("baseStr01").intern();

        System.out.println(str1 == str2);//#3
        System.out.println(str1 == str3);//#4
        System.out.println(str1 == str4);//#5
        System.out.println(str1 == str5);//#6
    }
}
