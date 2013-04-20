import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;

public class copyToLocal {

	private static FileSystem srcFs;

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		String[] otherArgs = null;
		try {
			otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    if (otherArgs.length != 2) {
	      System.err.println("Usage: copyToLocal <in> <out>");
	      System.exit(2);
	    }
		Path srcPath = new Path(args[0]);
		Path dstPath = new Path(args[1]);
		try {
			srcFs = srcPath.getFileSystem(conf);
			srcFs.copyToLocalFile(srcPath, dstPath);
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}

}
