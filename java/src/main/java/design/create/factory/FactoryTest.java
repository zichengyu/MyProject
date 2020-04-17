package design.create.factory;

/**
 * User: 20160301301
 * Date: 2017/9/12 16:45
 * Comment:
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();

        MailSender mailSender = SendFactory.produceMail();
        mailSender.Send();
    }
}