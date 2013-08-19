from webhdfs.webhdfs import WebHDFS
import os, tempfile
import time
import getpass
 
webhdfs = WebHDFS("localhost", 50070, getpass.getuser())
 
webhdfs.mkdir("/hello-world")
 
# create a temporary file
f = tempfile.NamedTemporaryFile()
f.write(b'Hello world!\n')
f.flush()
 
print "Upload file: " + f.name
 
webhdfs.copyFromLocal(f.name, "hello-world/test.txt")
webhdfs.copyToLocal("hello-world/test.txt", "test1.txt")

f.close()
