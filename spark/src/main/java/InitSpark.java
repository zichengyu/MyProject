import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * User: 20160301301
 * Date: 2018/3/27 17:04
 * Comment:
 */
public class InitSpark {
    public static void main(String[] args) {
        String inputFile = "D:\\Workspaces\\practice\\SinglePrpject\\SparkDemo\\src\\file\\input\\README.md";
        String outputPath = "D:\\Workspaces\\practice\\SinglePrpject\\SparkDemo\\src\\file\\output\\1";

        SparkConf conf = new SparkConf().setMaster("spark://centos74:7077").setAppName("My App").set("spark.ui.port", "4040");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> input = sc.textFile(inputFile);
        //JavaRDD<String> words = input.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
//        JavaPairRDD<String, Integer> counts = words
//                .mapToPair(
//                        s -> new Tuple2<String, Integer>(s, 1)
//                ).reduceByKey(
//                        (integer, integer2) -> integer + integer2);

        JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        JavaPairRDD<String, Integer> counts = words.mapToPair(
                new PairFunction<String, String, Integer>() {
                    @Override
                    public Tuple2<String, Integer> call(String s) throws Exception {
                        return new Tuple2<>(s, 1);
                    }
                }
        ).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });


        //counts.saveAsTextFile(outputPath);
        for (Tuple2<String, Integer> tuple2 : counts.take(10)) {
            System.out.println(tuple2.toString());
        }
    }
}