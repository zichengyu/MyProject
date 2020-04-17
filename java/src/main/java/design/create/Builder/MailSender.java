package design.create.Builder;

/**
 * User: 20160301301
 * Date: 2017/9/12 16:41
 * Comment:
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is MailSender!");
    }
}