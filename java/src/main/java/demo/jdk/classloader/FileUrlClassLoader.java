package demo.jdk.classloader;

import java.io.File;
import java.net.*;

/**
 * User: 20160301301
 * Date: 2018/5/23 9:11
 * Comment:
 */
public class FileUrlClassLoader extends URLClassLoader {

    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }


    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        String rootDir = "\\JavaDemo\\src\\main\\java";
        //创建自定义文件类加载器
        File file = new File(rootDir);
        //File to URI
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};

        FileUrlClassLoader loader = new FileUrlClassLoader(urls);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("demo.jdk.classloader.DemoObj");
            System.out.println(object1.newInstance().toString());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
