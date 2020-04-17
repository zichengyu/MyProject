package demo.jdk.grammar;

import java.io.*;

/**
 * @author :  20160301301
 * @date : 2018/8/9 10:46
 * 通过writeObject和readObject让transient可序列化：ObjectOutputStream会反射调用这两个方法
 *
 * 1、父类实现Serializable，子类默认实现Serializable
 * 2、子类实现Serializable，父类没实现，则父类属性不能序列化
 * 3、static和transient修饰的不能序列化
 */
public class TestSerialize implements Serializable {

    public transient String name;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerialize testSerialize =new TestSerialize();
        testSerialize.name = "aaa";
        System.out.println(testSerialize.name);
        System.out.println(testSerialize.hashCode());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(testSerialize);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        TestSerialize testSerialize1 = (TestSerialize) objectInputStream.readObject();

        System.out.println(testSerialize1.name);
        System.out.println(testSerialize1.hashCode());

    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        System.out.println("writeObject");
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(name);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        System.out.println("readObject");
        inputStream.defaultReadObject();
        name = (String) inputStream.readObject();
    }
}
