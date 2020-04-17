package temperature;

import org.apache.hadoop.io.WritableComparator;

/**
 * User: 20160301301
 * Date: 2018/3/8 20:09
 * Comment:
 */
public class SortHot extends WritableComparator {

    public SortHot() {
        super(KeyPair.class, true);
    }

    @Override
    public int compare(Object a, Object b) {
        KeyPair k1 = (KeyPair) a;
        KeyPair k2 = (KeyPair) b;
        int res = Integer.compare(k1.getYear(), k2.getYear());
        if (res != 0) {
            return res;
        }
        return -Integer.compare(k1.getHot(), k2.getHot());
    }
}
