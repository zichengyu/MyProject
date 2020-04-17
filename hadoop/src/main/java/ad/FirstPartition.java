package ad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;


/**
 * User: 20160301301
 * Date: 2018/3/10 11:39
 * Comment:
 * 如果key为count，单独分为一个区
 * 其他的key，平均分为三个区
 */
public class FirstPartition extends HashPartitioner<Text, IntWritable> {
    @Override
    public int getPartition(Text key, IntWritable value, int numReduceTasks) {
        if (key.equals(new Text("count"))) {
            return 3;
        } else {
            return super.getPartition(key, value, numReduceTasks - 1);
        }
    }
}
