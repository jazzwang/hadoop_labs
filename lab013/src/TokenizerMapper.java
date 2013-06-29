import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper 
     extends Mapper<Object, Text, Text, IntWritable>{
  
  private final static IntWritable one = new IntWritable(1);
  private Text word = new Text();
  private boolean caseSensitive = true;
  private String inputFile;
  
  public void setup(Context context)
  {
      System.out.println("TokenizerMapper.setup(Context)");
      Configuration conf = context.getConfiguration();
      caseSensitive = conf.getBoolean("wordcount.case.sensitive", true);
      inputFile = conf.get("map.input.file");
      System.out.println("case sensitive : " + caseSensitive );
      System.out.println("input file : " + inputFile );
  }
    
  public void map(Object key, Text value, Context context
                  ) throws IOException, InterruptedException {
    System.out.println("TokenizerMapper.map(key, value, Context)");
    String line = (caseSensitive) ? value.toString() : value.toString().toLowerCase();
    StringTokenizer itr = new StringTokenizer(line);
    while (itr.hasMoreTokens()) {
      word.set(itr.nextToken());
      context.write(word, one);
    }
  }

  public void cleanup(Context context)
  {
    System.out.println("TokenizerMapper.cleanup(Context)");
  }
}
