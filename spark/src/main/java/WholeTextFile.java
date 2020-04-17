import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * User: 20160301301
 * Date: 2018/4/4 10:24
 * Comment: 读取整个文件，求平均值
 */
public class WholeTextFile {

    public static void main(String[] args) {
        String inputFile = "D:\\Workspaces\\practice\\SinglePrpject\\SparkDemo\\src\\file\\input\\README.md";
        String outputPath = "D:\\Workspaces\\practice\\SinglePrpject\\SparkDemo\\src\\file\\output\\1";

        SparkConf conf = new SparkConf().setMaster("local").setAppName("My App").set("spark.ui.port", "4040");
        JavaSparkContext sc = new JavaSparkContext(conf);

        //键是文件的文件名，值是
        JavaPairRDD<String, String> data = sc.wholeTextFiles(inputFile);
//        JavaPairRDD<String, String> sum = data.mapValues(s -> s.split(" ")).map(new Function<Tuple2<String,String[]>, Object>() {
//            @Override
//            public Object call(Tuple2<String, String[]> stringTuple2) throws Exception {
//                for (String s: stringTuple2._2){
//
//                }
//                return args.hashCode();
//            }
//        });
    }
}
