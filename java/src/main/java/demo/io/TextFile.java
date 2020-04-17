package demo.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: 20160301301
 * Date: 2017/9/15 21:40
 * Comment:
 */
public class TextFile extends ArrayList<String> {
    private static final long serialVersionUID = -1942855619975438512L;

    // Read a file as a String
    public static String read(String filename) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
            String s;
            try {
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // Write a single file in one method call
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            out.write(text);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read a file,spilt by any regular expression
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")){
            remove(0);
        }
    }

    // Normally read by lines
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(new File(fileName).getAbsoluteFile()));
            try {
                for (String item:this){
                    out.write(item);
                }
            }finally {
                out.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test,I have generated a file named data.d at the root
    public static void main(String[] args) {

        /* read() test */
        System.out.println(read("data.d")); // testing is OK!

        /* write() test */
        write("out.d", "helloworld\negg"); // testing is OK!

        /* constractor test */
        TextFile tf = new TextFile("data.d"); // testing is OK!

    }

}