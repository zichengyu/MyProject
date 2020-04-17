package ad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;

/**
 * User: 20160301301
 * Date: 2018/3/10 11:14
 * Comment:
 * 统计每条微博各个词出现的总次数，
 * TF统计为一个文件，N统计为另外一个文件
 * 输出为：
 * 第一种：词_微博ID 出现次数（TF）
 * 第二种：count 微博条数（N）
 */
public class FirstReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for(IntWritable i : values) {
            sum = sum + i.get();
        }

        if (key.equals(new Text("count"))) {
            System.out.println(key.toString() + "______" + sum);
        }
        context.write(key, new IntWritable(sum));
    }
}
