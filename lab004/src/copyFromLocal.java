import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;

public class copyFromLocal {

	private static FileSystem dstFs;

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		String[] otherArgs = null;
		try {
			otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    if (otherArgs.length != 2) {
	      System.err.println("Usage: copyFromLocal <in> <out>");
	      System.exit(2);
	    }
		Path srcPath = new Path(args[0]);
		Path dstPath = new Path(args[1]);
		try {
			dstFs = dstPath.getFileSystem(conf);
			dstFs.copyFromLocalFile(false, srcPath, dstPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
