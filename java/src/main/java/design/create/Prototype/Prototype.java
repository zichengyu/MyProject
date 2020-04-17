package design.create.Prototype;

import java.io.*;

/**
 * User: 20160301301
 * Date: 2017/9/12 19:43
 * Comment:
 */
public class Prototype implements Cloneable {

    private static final long serialVersionUID = 1L;
    private String string;

    private SerializableObject obj;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }
}