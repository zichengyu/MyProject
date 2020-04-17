package ad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * User: 20160301301
 * Date: 2018/3/10 10:19
 * Comment:
 */
// 计算每个词在该条微博中出现的次数 - 权重公式的 TF
public class FirstMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] v = value.toString().trim().split("\t");
        if (v.length >= 2) {
            String id = v[0].trim();
            String content = v[1].trim();

            StringReader sr = new StringReader(content);
            IKSegmenter ikSegmenter = new IKSegmenter(sr, true);
            Lexeme word = null;
            while ((word = ikSegmenter.next()) != null) {
                String w = word.getLexemeText();
                // 统计TF
                context.write(new Text(w + "_" + id), new IntWritable(1));
            }
            //用于计算微博的总条数 - N
            context.write(new Text("count"), new IntWritable(1));
        } else {

        }
    }
}
