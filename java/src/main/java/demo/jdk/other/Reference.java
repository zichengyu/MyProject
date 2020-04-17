package demo.jdk.other;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author :  20160301301
 * @date : 2018/7/30 15:57
 */
public class Reference {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        //创建一个对象
        User user = new User();
        user.setUsername("user");
        //创建一个引用队列    
        ReferenceQueue<User> rq = new ReferenceQueue<User>();
        //创建一个虚引用，让此虚引用引用到person对象
        WeakReference<User> pr = new WeakReference<User>(user, rq);
        //切断person引用变量和对象的引用
        //user = null;
        //试图取出虚引用所引用的对象
        //发现程序并不能通过虚引用访问被引用对象，所以此处输出为null
        System.out.println(pr.get());

        user = null;

        //强制垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println("user:" + user);

        //因为一旦虚引用中的对象被回收后，该虚引用就会进入引用队列中
        //所以用队列中最先进入队列中引用与pr进行比较，输出true
        System.out.println(rq.poll() == pr);
    }

    public static class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
