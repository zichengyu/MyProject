package ad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * User: 20160301301
 * Date: 2018/3/10 14:10
 * Comment:
 * 统计每个词的DF
 */
public class TwoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FileSplit fs = (FileSplit) context.getInputSplit();
        //获取到当前片段所在的文件名，判断当前片段是哪种类型（00003统计的是总的微博条数）
        if (!fs.getPath().getName().contains("part-r-00003")) {
            String[] v = value.toString().trim().split("\t");
            if (v.length >= 2) {
                String[] ss = v[0].split("_");
                if (ss.length >= 2) {
                    String w = ss[0];
                    //统计某词在那些微博中出现过 - DF
                    context.write(new Text(w), new IntWritable(1));
                }
            } else {
                System.out.println(value.toString());
            }
        }
    }
}
