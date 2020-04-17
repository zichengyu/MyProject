package temperature;

import org.apache.hadoop.io.WritableComparator;

/**
 * User: 20160301301
 * Date: 2018/3/8 20:09
 * Comment:
 */
public class GroupHot extends WritableComparator {

    public GroupHot() {
        super(KeyPair.class, true);
    }

    @Override
    public int compare(Object a, Object b) {
        KeyPair k1 = (KeyPair) a;
        KeyPair k2 = (KeyPair) b;
        return Integer.compare(k1.getYear(), k2.getYear());
    }
}
