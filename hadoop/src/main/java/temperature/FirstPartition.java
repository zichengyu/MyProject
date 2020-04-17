package temperature;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


/**
 * User: 20160301301
 * Date: 2018/3/8 20:15
 * Comment:
 */
public class FirstPartition extends Partitioner<KeyPair, Text> {
    @Override
    public int getPartition(KeyPair keyPair, Text text, int num) {
        return keyPair.getYear() * 127 % num;
    }

}
