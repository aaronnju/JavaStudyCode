import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by shuming.wang on 2017/8/31.
 */
public class TryWithResource {
    static String readFirstLineFromFileWithFinallyBlock(String path){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        } finally {
            System.out.println("finally");
        }
        return "";
    }
    public static void main(String[] args){
        readFirstLineFromFileWithFinallyBlock("d");
    }
}
