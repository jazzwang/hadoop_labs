import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper 
     extends Mapper<Text, Text, Text, IntWritable>{
  
  private IntWritable val = new IntWritable();
    
  public void map(Text key, Text value, Context context
                  ) throws IOException, InterruptedException {
	  val.set(Integer.parseInt(value.toString()));
      context.write(key, val);
  }
}
