package demo.jdk.stack;

/**
 * User: 20160301301
 * Date: 2018/5/5 15:14
 * Comment:
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes i am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finialize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no i am die");
        }
        //2
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no i am die");
        }
    }
}
