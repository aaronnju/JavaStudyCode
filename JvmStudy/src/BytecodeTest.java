/**
 * Created by shuming.wang on 2017-2-7.
 */
public class BytecodeTest {
    public static void main1(String[] args) {
        String str2 = new String("str")+new String("01");
        str2.intern();
        System.out.println(str2==str2.intern());
        String str1 = "str01";
        System.out.println(str2==str1);//#7
    }

    public static void main(String[] args) {
        String str1 = "str01";
        String str2 = new String("str")+new String("01");
        str2.intern();
        System.out.println(str2==str2.intern());
        System.out.println(str2 == str1);//#8
    }

}
