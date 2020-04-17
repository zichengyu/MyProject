package design.create.AbstractFactory;

/**
 * User: 20160301301
 * Date: 2017/9/12 16:57
 * Comment:
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mail sender!");
    }
}