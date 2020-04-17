package design.struct.Bridge;

/**
 * User: 20160301301
 * Date: 2017/9/15 17:07
 * Comment:
 */
public abstract class Bridge {
    private Sourceable sourceable;

    public Sourceable getSourceable() {
        return sourceable;
    }

    public void setSourceable(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public void method(){
        sourceable.method();
    }

}