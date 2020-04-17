package middleware.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: 20160301301
 * Date: 2017/9/16 14:28
 * Comment:
 */
public class AppProducer {

    private static final String url = "tcp://192.168.10.72:61616";
    private static final String queueName = "topic-test";
    public static void main(String[] args) throws Exception{
        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //2、创建Connection
        Connection connection = connectionFactory.createConnection();
        //3、启动连接
        connection.start();
        //4、创建会话
        Session session =  connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //5、创建一个目标
        Destination destination =  session.createTopic(queueName);
        //6、创建生产者
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0;i<1000;i++){
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("demo" +i);
            //8、发布消息
            producer.send(textMessage);
            System.out.println("发送消息"+textMessage.getText());
        }
        //9、关闭连接
        connection.close();
    }
}