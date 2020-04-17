package demo.io;

import java.io.*;

/**
 * User: 20160301301
 * Date: 2017/9/15 21:26
 * Comment:
 */
public class BasicFileOutput {
    static String file = "basie.out";

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new StringReader(
                InputStreamTest.read("src/main/java/test/io/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter((new BufferedWriter(new FileWriter(file))));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(InputStreamTest.read(file));
    }
}