import java.io.*;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class TokenizerMapper 
     extends Mapper<Object, Text, Text, IntWritable>{
  
  private final static IntWritable one = new IntWritable(1);
  private Text word = new Text();
  private boolean caseSensitive = true;
  private Set<String> patternsToSkip = new HashSet<String>();
  
  public void setup(Context context)
  {
    System.out.println("TokenizerMapper.setup(Context)");
    Configuration conf = context.getConfiguration();
    caseSensitive = conf.getBoolean("wordcount.case.sensitive", true);
    System.out.println("case sensitive : " + caseSensitive );
    Path[] patternsFiles = new Path[0];
    patternsFiles = DistributedCache.getLocalCacheFiles(conf);
    for (Path patternsFile : patternsFiles) {
      parseSkipFile(patternsFile);
    }
  }

  private void parseSkipFile(Path patternsFile) {
    BufferedReader fis = new BufferedReader(new FileReader(patternsFile.toString()));
    String pattern = null;
    while ((pattern = fis.readLine()) != null) {
      patternsToSkip.add(pattern);
    }
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
