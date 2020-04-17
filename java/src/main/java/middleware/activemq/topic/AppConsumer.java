package middleware.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: 20160301301
 * Date: 2017/9/16 14:43
 * Comment:
 */
public class AppConsumer {
    private static final String url = "tcp://192.168.10.72:61616";
    private static final String queueName = "topic-test";

    public static void main(String[] args) throws Exception {
        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //2、创建Connection
        Connection connection = connectionFactory.createConnection();
        //3、启动连接
        connection.start();
        //4、创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、创建一个目标
        Destination destination = session.createTopic(queueName);
        //6、创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //7、创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //9、关闭连接
//        connection.close();
    }
}