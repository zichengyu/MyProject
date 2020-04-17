package ad;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.text.SimpleDateFormat;

/**
 * User: 20160301301
 * Date: 2018/3/8 20:26
 * Comment:
 */
public class FirstJob {

    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.set("yarn-site.xmlresourcemanager.hostname", "hadoop1");
        try {
            Job job = new Job(conf);
            job.setJarByClass(FirstJob.class);
            job.setJobName("weibo1");
            //设置map任务的输出key和value类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);

            job.setNumReduceTasks(4); //设置reduce的个数
            job.setPartitionerClass(FirstPartition.class);  //定义某个数据发送给那个reduce
            job.setMapperClass(FirstMapper.class);
            job.setCombinerClass(FirstReduce.class); //精简压缩传给Reduce的数据，且不影响最终的结果
            job.setReducerClass(FirstReduce.class);
            //job.setSortComparatorClass(SortHot.class);      //对进入同一个reduce的键或键的部分 进行排序(reduce接受数据阶段)
            //job.setGroupingComparatorClass(GroupHot.class); //定义那些bean会被reduce看成同样的，构造一个key对应的value迭代器，进行一次reduce函数的处理（reduce接受数据阶段）

            //设置mr运行时输入数据和输出数据在hdfs的那个目录
            FileInputFormat.addInputPath(job, new Path("/usr/input/hot"));
            FileOutputFormat.setOutputPath(job, new Path("/usr/output/hot"));
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
