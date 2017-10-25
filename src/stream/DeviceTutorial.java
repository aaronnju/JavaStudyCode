package stream;

import java.io.File;

/**
 * Created by shuming.wang on 2016-9-23.
 */
public class DeviceTutorial {
    void testFile(){
        File file = new File("C:\\Windows\\WindowsUpdate.log");
        System.out.println(file.getName());
    }
    public static void main(String[] args){

    }
}
