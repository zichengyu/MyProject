package temperature;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: 20160301301
 * Date: 2018/3/8 20:26
 * Comment:
 */
public class RunJob {

    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static class HotMapper extends Mapper<LongWritable, Text, KeyPair, Text> {


        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] ss = line.split("\t");
            if (ss.length == 2) {
                try {
                    Date date = SDF.parse(ss[0]);
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);

                    int year = c.get(Calendar.YEAR);
                    String hotStroing = ss[1].substring(0, ss[1].indexOf("℃"));
                    int hot = Integer.parseInt(hotStroing);

                    KeyPair k = new KeyPair();
                    k.setYear(year);
                    k.setHot(hot);

                    context.write(k, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class HotReduce extends Reducer<KeyPair, Text, KeyPair, Text> {
        @Override
        protected void reduce(KeyPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            for (Text value : values) {
                context.write(key, value);
            }
        }
    }

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        try {
            Job job = new Job(conf);
            job.setJobName("hot");
            job.setJarByClass(RunJob.class);
            job.setMapperClass(HotMapper.class);
            job.setReducerClass(HotReduce.class);
            job.setMapOutputKeyClass(KeyPair.class);
            job.setMapOutputValueClass(Text.class);

            job.setNumReduceTasks(3); //跟年份保持一致，这样每个年份会输出一个数据文件
            job.setPartitionerClass(FirstPartition.class);  //定义某个数据发送给那个reduce
            job.setSortComparatorClass(SortHot.class);      //对进入同一个reduce的键或键的部分 进行排序(reduce接受数据阶段)
            job.setGroupingComparatorClass(GroupHot.class); //定义那些bean会被reduce看成同样的，构造一个key对应的value迭代器，进行一次reduce函数的处理（reduce接受数据阶段）

            FileInputFormat.addInputPath(job, new Path("/usr/input/hot"));
            FileOutputFormat.setOutputPath(job, new Path("/usr/output/hot"));
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
