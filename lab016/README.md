## Example for Combiner and NullWritable

This is a example to explain the limitation of Combiner.
You should see exceptions like this:
```
java.io.IOException: Type mismatch in value from map: expected org.apache.hadoop.io.IntWritable, recieved org.apache.hadoop.io.NullWritable
	at org.apache.hadoop.mapred.MapTask$MapOutputBuffer.collect(MapTask.java:1019)
	at org.apache.hadoop.mapred.MapTask$NewOutputCollector.write(MapTask.java:691)
```
