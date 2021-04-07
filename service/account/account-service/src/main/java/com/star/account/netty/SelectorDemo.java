package com.star.account.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ZhuYX
 * @date 2021/04/07
 */
public class SelectorDemo {

    public static void main(String[] args) {

    }

    public static void select_test() throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 7788);

        channel.bind(inetSocketAddress);

        channel.configureBlocking(false);

        // 打开一个选择器
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);

        for (; ; ) {
            if (selector.select(3000) == 0) {
                continue;
            }
            // 获取就绪事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                // 事件
                SelectionKey key = keyIterator.next();
                // 如果是连接事件
                if (key.isAcceptable()) {
                    //服务器与客户端建立连接，获取socketChannel
                    SocketChannel socketChannel = channel.accept();
                    //设置成非阻塞
                    socketChannel.configureBlocking(false);
                    //把socketChannel注册到selector中，监听读事件，并绑定一个缓冲区
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //
                else if (key.isReadable()) {
//获取通道
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //获取关联的ByteBuffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    //打印从客户端获取到的数据
                    socketChannel.read(buffer);
                    System.out.println("from 客户端：" + new String(buffer.array()));
                }
                //从事件集合中删除已处理的事件，防止重复处理
                keyIterator.remove();
            }

        }
    }
}
