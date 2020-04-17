package ad;

import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;

/**
 * User: 20160301301
 * Date: 2018/3/10 14:40
 * Comment:
 */
public class LastReduce extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // todo
    }
}
