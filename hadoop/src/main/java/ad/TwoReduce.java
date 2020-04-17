package ad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;

/**
 * User: 20160301301
 * Date: 2018/3/10 14:39
 * Comment:
 * 输出某个关键词在出现过的微博总条数
 * 输入格式：关键字 1
 * 输出格式：关键字 微博条数
 */
public class TwoReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable i: values) {
            sum += i.get();
        }
        context.write(key, new IntWritable(sum));
    }
}
