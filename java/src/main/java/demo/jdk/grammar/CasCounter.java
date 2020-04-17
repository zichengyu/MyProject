package demo.jdk.grammar;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: 20160301301
 * Date: 2017/10/26 16:20
 * Comment:
 */
public class CasCounter {
    private SimulatedCAS value;

    public CasCounter(SimulatedCAS value) {
        this.value = value;
    }

    public int getValue() {
        return value.getValue();
    }

    public int increment() {
        int oldValue = value.getValue();
        if (value.compareAndSwap(oldValue , oldValue + 1) != oldValue){
            oldValue = value.getValue();
        }
        return oldValue + 1;
    }

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        System.out.println(ai);
        ai.getAndIncrement();
        System.out.println(ai);
    }

    public class SimulatedCAS {
        private int value = 1;
        public synchronized int getValue() {
            return value;
        }

        public synchronized int compareAndSwap(int expectedValue, int newValue) {
            int oldValue  = value;
            if (value != expectedValue) {
                value = newValue;
            }
            return oldValue;
        }
    }
}