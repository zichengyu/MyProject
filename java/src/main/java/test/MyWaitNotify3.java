package test;

/**
 * @author :  20160301301
 * @date : 2018/8/29 9:42
 */
public class MyWaitNotify3 {
    Object myMonitorObject = new Object();
    boolean wasSignalled = false;

    public void doWait(){
        synchronized(myMonitorObject){
            while(!wasSignalled){
                try{
                    System.out.println("w");
                    myMonitorObject.wait();

                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    public void doNotify(){
        synchronized(myMonitorObject){
            System.out.println("n");
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyWaitNotify3 waitNotify3 = new MyWaitNotify3();
        waitNotify3.doNotify();
        waitNotify3.doWait();
        Thread.sleep(1000);


    }

}
