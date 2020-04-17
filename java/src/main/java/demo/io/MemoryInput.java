package demo.io;

import java.io.StringReader;

/**
 * User: 20160301301
 * Date: 2017/9/15 21:21
 * Comment:
 */
public class MemoryInput {
    public static void main(String[] args) throws Exception {
        StringReader in  = new StringReader(InputStreamTest.read("src/main/java/test/io/MemoryInput.java"));
        int c;
        while ((c = in.read()) !=-1){
            System.out.println((char) c);
        }

    }
}