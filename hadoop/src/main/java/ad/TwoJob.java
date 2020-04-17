package ad;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * User: 20160301301
 * Date: 2018/3/10 14:18
 * Comment:
 */
public class TwoJob {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.set("yarn.resourcemanager.hostname", "hadoop1");
        try {
            Job job = new Job(conf);
            job.setJarByClass(TwoJob.class);
            job.setJobName("weibo2");
            //设置map任务的输出key和value类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);

            job.setMapperClass(TwoMapper.class);
            job.setCombinerClass(TwoReduce.class);
            job.setReducerClass(TwoReduce.class);
            //job.setSortComparatorClass(SortHot.class);      //对进入同一个reduce的键或键的部分 进行排序(reduce接受数据阶段)
            //job.setGroupingComparatorClass(GroupHot.class); //定义那些bean会被reduce看成同样的，构造一个key对应的value迭代器，进行一次reduce函数的处理（reduce接受数据阶段）

            //设置mr运行时输入数据和输出数据在hdfs的那个目录
            FileInputFormat.addInputPath(job, new Path("/usr/weibo/output1"));
            FileOutputFormat.setOutputPath(job, new Path("/usr/weibo/output2"));
            boolean f = job.waitForCompletion(true);
            if (f) {
                System.out.println("job执行成功");
            } else {
                System.out.println("job执行失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
