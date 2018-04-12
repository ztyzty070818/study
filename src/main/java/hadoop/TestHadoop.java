package hadoop;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestHadoop {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.setProperty("HADOOP_USER_NAME","hdfs");
//        listAllFiles("/test");
//        mkdir("/test/test");
//        listAllFiles("/test");
//        dtDir("/test/test");
//        listAllFiles("/test");
//        download("hdfs://192.168.0.221/test/word_count", "tmp/hadoop/test");
//        upload("/tmp/hadoop/test/1234","hdfs://192.168.0.221/test/");
        getNodeMessage();
        getBlockLocations();
    }

    public static FileSystem getFileSystem() throws URISyntaxException, IOException {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.0.221");
        FileSystem fs = FileSystem.get(uri, conf);
        return fs;
    }

    public static void mkdir(String path) throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();
        fs.mkdirs(new Path(path));
        System.out.println("make dir:" + path);
        fs.close();
    }

    public static void listAllFiles(String dstPath) throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        FileStatus[] status = fs.listStatus(new Path("hdfs://192.168.0.221" + dstPath));

        Path[] listPaths = FileUtil.stat2Paths(status);

        StringBuffer buff = new StringBuffer(dstPath);
        buff.append(":\t");
        for(Path path : listPaths) {
            buff.append(path.getName() + "\t");
        }
        System.out.println(buff);
    }

    public static void dtDir(String path) throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        // 递归删除
        fs.delete(new Path(path), true);

        System.out.println("delete dir:" + path);

        fs.close();
    }

    public static void download(String srcPath, String dstPath) throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        fs.copyToLocalFile(new Path(srcPath), new Path(dstPath) );

        System.out.println( String.format("copy from %s to local: %s", srcPath, dstPath) );

        fs.close();

    }

    public static void upload(String srcPath, String dstPath) throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        fs.copyFromLocalFile(new Path(srcPath), new Path(dstPath) );

        System.out.println( String.format("copy local： %s to hdfs: %s", srcPath, dstPath) );

        fs.close();
    }

    public static void getNodeMessage() throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        DistributedFileSystem dfs = (DistributedFileSystem) fs;

        DatanodeInfo[] di = dfs.getDataNodeStats();
        for(int i=0; i<di.length; i++) {
            System.out.println(di[i].getHostName());
        }
    }

    public static void getBlockLocations() throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        FileStatus fileStatus = fs.getFileStatus(new Path("/test/word_count"));

        BlockLocation[] bls = fs.getFileBlockLocations(fileStatus, 0, 1);

        for(BlockLocation bl : bls) {
            String names[] = bl.getNames();
            String hosts[] = bl.getHosts();
            for(int j=0; j<names.length; j++) {
                System.out.println(names[j] + ":" + hosts[j]);
            }
        }
    }

    public static void betchUpload() throws IOException, URISyntaxException {
        FileSystem fs = getFileSystem();

        FileSystem local = FileSystem.getLocal(new Configuration());
    }
}
