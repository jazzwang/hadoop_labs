import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;

public class isFile {
  
  private static FileSystem srcFs;
  
  public static void main(String[] args) {
    Configuration conf = new Configuration();
    String[] otherArgs = null;
    
    try {
      otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    
    if (otherArgs.length != 1) {
      System.err.println("Usage: isFile <path>");
      System.exit(2);
    }
    
    Path srcPath = new Path(args[0]);
    try {
      srcFs = srcPath.getFileSystem(conf);
      System.out.println("isFile: "	 + srcFs.isFile(srcPath));
      System.out.println("isDirectory: " + srcFs.isDirectory(srcPath));
    } catch (IOException e) {			
      e.printStackTrace();
    }		
  }
}
