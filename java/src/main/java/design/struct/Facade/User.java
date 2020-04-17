package design.struct.Facade;

/**
 * User: 20160301301
 * Date: 2017/9/15 17:01
 * Comment:
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}