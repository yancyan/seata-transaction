package com.star.account.netty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author ZhuYX
 * @date 2021/04/07
 */
public class ChannelDemo {

    /**
     * FileChannel，读写文件中的数据。
     * SocketChannel，通过TCP读写网络中的数据。
     * ServerSockectChannel，监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
     * DatagramChannel，通过UDP读写网络中的数据。
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // fileChannel_test();
        // socketChannel_test();
        chToCh();
    }


    public static void chToCh() throws Exception {
        //获取文件输入流

        File file = new File("abc.txt");
        FileChannel fileChannel = new FileInputStream(file).getChannel();

        FileChannel fileChannelTo = new FileOutputStream("abc_to.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        // fileChannel.transferTo(0, byteBuffer.limit(), fileChannelTo);
        fileChannelTo.transferFrom(fileChannel,0,byteBuffer.limit());

        fileChannel.close();
        fileChannelTo.close();
    }

    public static void fileChannel_test() throws Exception {
        //获取文件输入流

        File file = new File("abc.txt");
        FileChannel fileChannel = new FileInputStream(file).getChannel();

        FileChannel fileChannelTo = new FileOutputStream("abc_to.txt").getChannel();

        //创建一个byteBuffer，小文件所以就直接一次读取，不分多次循环了
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        //把输入流通道的数据读取到缓冲区
        fileChannel.read(byteBuffer);
        //切换成读模式
        byteBuffer.flip();
        //把数据从缓冲区写入到输出流通道
        fileChannelTo.write(byteBuffer);
        //关闭通道
        fileChannel.close();
        fileChannelTo.close();
    }

    public static void socketChannel_test() throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 7788);

        socketChannel.bind(socketAddress);

        ByteBuffer allocate = ByteBuffer.allocate(100);
        for (; ; ) {
            SocketChannel accept = socketChannel.accept();
            while (accept.read(allocate) != -1) {
                System.out.println("accept: " + new String(allocate.array()));
                // 清空缓存区
                allocate.clear();
            }
        }

    }
}
