package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNio {
    public static void main(String[] args) throws IOException {
        copyFileUseNIO("/tmp/test/src", "/tmp/test/dst2");
    }

    public static void copyFileUseNIO(String src, String dst) throws IOException {
        FileInputStream fi = new FileInputStream(new File(src));
        FileOutputStream fo = new FileOutputStream(new File(dst));

        //获取传输通道channel
        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();

        //获取容器buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //判断是否读完文件
        while(inChannel.read(byteBuffer) != -1) {
            //重设一下buffer的position=0，limit=position
            byteBuffer.flip();
            //开始写
            outChannel.write(byteBuffer);
            //写完要重置buffer，重设position=0,limit=capacity
            byteBuffer.clear();
        }

        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }

    public static void test() {
//        AtomicInteger;
//                Integer
//        SelectionKey.OP_ACCEPT
    }
}
