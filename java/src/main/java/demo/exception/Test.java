package demo.exception;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * User: 20160301301
 * Date: 2017/9/11 20:13
 * Comment:
 */
public class Test {
    public static void main(String[] args) {
        String filename = "d:\\test.txt";
        try {
            FileReader reader = new FileReader(filename);
            Scanner in = new Scanner(reader);
            String input = in.next();
            int value = Integer.parseInt(input);
            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("this is finally block!");
        }
    }
}