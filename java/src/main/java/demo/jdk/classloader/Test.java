package demo.jdk.classloader;

/**
 * User: 20160301301
 * Date: 2018/5/23 9:19
 * Comment:
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        String rootDir = "D:\\Workspaces\\practice\\SinglePrpject\\JavaDemo\\target\\classes\\";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件,调用loadClass()
            Class<?> object1 = loader.loadClass("demo.jdk.classloader.DemoObj");
            Class<?> object2 = loader2.loadClass("demo.jdk.classloader.DemoObj");

            System.out.println("loadClass->obj1:" + object1.hashCode());
            System.out.println("loadClass->obj2:" + object2.hashCode());

            //加载指定的class文件,直接调用findClass(),绕过检测机制，创建不同class对象。
            Class<?> object3 = loader.findClass("demo.jdk.classloader.DemoObj");
            Class<?> object4 = loader2.findClass("demo.jdk.classloader.DemoObj");

            System.out.println("loadClass->obj3:" + object3.hashCode());
            System.out.println("loadClass->obj4:" + object4.hashCode());

            /**
             * 输出结果:
             * loadClass->obj1:644117698
             loadClass->obj2:644117698
             findClass->obj3:723074861
             findClass->obj4:895328852
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
