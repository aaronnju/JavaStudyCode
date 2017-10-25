/**
 * Created by shuming.wang on 2017/8/21.
 */
public class ClassBytecode {
    public int mInt;
    public static double mDouble;
    public int inc(){
        return mInt + 1;
    }
    public static void main(String[] args) {
        ClassBytecode tt = new ClassBytecode();
        tt.mInt = 1;
        System.out.print(tt.mInt);
    }
}
