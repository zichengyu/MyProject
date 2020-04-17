package design.create.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 20160301301
 * Date: 2017/9/12 19:37
 * Comment:
 */
public class Builder {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}