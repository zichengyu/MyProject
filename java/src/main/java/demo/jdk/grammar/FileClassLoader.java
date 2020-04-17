package demo.jdk.grammar;

import java.io.*;

/**
 * User: 20160301301
 * Date: 2018/3/27 11:12
 * Comment:
 */
public class FileClassLoader extends ClassLoader {

    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    // 编写获取类的字节码并创建class对象的逻辑
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    //编写读取字节流的方法
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) {
        String rootDir = "D:\\Workspaces";
        FileClassLoader loader1 = new FileClassLoader(rootDir);

        try {
            Class<?> object1 = loader1.loadClass("demo.jdk.grammar.FutureTaskTest");
            System.out.println(object1.newInstance().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());

        /**
         输出结果:
         自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
         系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
         AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
         ExtClassLoader的父类加载器: null
         */
    }
}
