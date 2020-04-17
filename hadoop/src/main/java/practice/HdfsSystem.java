package practice; /**
 * User: 20160301301
 * Date: 2018/3/19 20:39
 * Comment: HDFS文件操作
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

public class HdfsSystem {

    @BeforeClass
    private static void init() throws Exception {
//        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//        conf.set("fs.defaultFS", "hdfs://centos74:9000");
//        conf.set("dfs.permissions.enable", "false");
//        conf.set("dfs.permissions.superusergroup", "root");
//        conf.set("hadoop.job.user","root");
//        conf.set("mapreduce.app-submission.cross-platform", "true");
        System.setProperty("HADOOP_USER_NAME", "root");
    }

    @Test
    public static void createHdfs() throws IOException {
        String uri = "/b.txt";
        String content = "TEST HADOOP HDFS";

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        byte[] buff = content.getBytes();
        FSDataOutputStream os = null;
        try {
            os = fs.create(new Path(uri), true);
            os.write(buff, 0, buff.length);
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
        fs.close();
    }

    @Test
    public static void appendHdfs() throws IOException {
        String uri = "/b.txt";
        String content = "TEST HADOOP HDFS";

        Configuration conf = new Configuration();
        conf.setBoolean("dfs.support.append", true);
        conf.set("dfs.client.block.write.replace-datanode-on-failure.enable", "true");
        conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");

        FileSystem fs = FileSystem.get(conf);
        //要追加的文件流，inpath为文件
        InputStream in = new
                BufferedInputStream(new ByteArrayInputStream(content.getBytes()));
        OutputStream outputStream = fs.append(new Path(uri));
        outputStream.write("aaaaaaaaaaaaaaaaa".getBytes());
        IOUtils.copyBytes(in, outputStream, 4096, true);
    }
}
