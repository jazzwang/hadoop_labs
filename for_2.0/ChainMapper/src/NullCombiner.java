import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class NullCombiner
     extends Mapper<Text,NullWritable,Text,IntWritable> {
  private IntWritable result = new IntWritable();

  public void map(Text key, Iterable<NullWritable> values, 
                     Context context
                     ) throws IOException, InterruptedException {
    int sum = 0;
    for (NullWritable val : values) {
      sum = sum + 1;
    }
    result.set(sum);
    context.write(key, result);
  }
}
