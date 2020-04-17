package demo.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * User: 20160301301
 * Date: 2017/9/15 20:57
 * Comment:
 */
public class InputStreamTest {

    public static String read(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = br.readLine()) != null) {
                sb.append(s + "\n");
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(read("JavaDemo\\src\\main\\java\\demo\\io\\InputStreamTest.java"));

    }

}