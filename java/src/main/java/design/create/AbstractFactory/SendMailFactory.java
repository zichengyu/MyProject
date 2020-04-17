package design.create.AbstractFactory;

/**
 * User: 20160301301
 * Date: 2017/9/12 17:00
 * Comment:
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}