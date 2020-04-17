package design.create.Builder;

/**
 * User: 20160301301
 * Date: 2017/9/12 16:40
 * Comment:
 */
public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("This is SmsSender!");
    }
}