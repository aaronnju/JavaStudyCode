import sun.net.www.http.Hurryable;

import java.math.BigInteger;

/**
 * Created by shuming.wang on 2017-2-3.
 */
public class StaticDispatch {
    static abstract class  Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void SayHello(Human h){
        System.out.println("Hello guy");
    }
    public void SayHello(Man h){
        System.out.println("Hello gentleman");
    }
    public void SayHello(Woman h){
        System.out.println("Hello lady");
    }


    static public void main0(String[] args){

        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch di = new StaticDispatch();
        di.SayHello(man);
        di.SayHello(woman);

        di.SayHello((Woman)woman);

        int[][][] array = new int[1][0][-1];
    }

}

