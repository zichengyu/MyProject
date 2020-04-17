package middleware.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: 20160301301
 * Date: 2017/9/16 14:28
 * Comment:
 */
public class AppProducer {

    private static final String url = "tcp://192.168.2.167:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws Exception {
        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //是否异步发送消息到broker而不等待broker的反馈，非持久化消息模式下，默认就是异步发送过程
        ((ActiveMQConnectionFactory) connectionFactory).setUseAsyncSend(false);
        //回执窗口大小设置
        ((ActiveMQConnectionFactory) connectionFactory).setProducerWindowSize(10000);
        //2、创建Connection
        Connection connection = connectionFactory.createConnection();
        //3、启动连接
        connection.start();
        //4、创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、创建一个目标
        Destination destination = session.createQueue(queueName);
        //6、创建生产者
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 1000; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("demo" + i);
            //设置消息发送的模式是持久化还是非持久化，默认情况下，生产者发送的消息是持久化的
            textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
            //8、发布消息
            producer.send(textMessage);
            System.out.println("发送消息" + textMessage.getText());
        }
        //9、关闭连接
        connection.close();
    }
}