package demo.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * User: 20160301301
 * Date: 2017/9/15 21:35
 * Comment:
 */
public class StandardIO {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0){
            System.out.println(s);
        }

//        Scanner in = new Scanner(System.in);
//        String s;
//        while((s = in.next()) != null && s.length() != 0){
//            System.out.println(s);
//        }
    }
}