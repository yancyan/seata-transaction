package com.star.account.netty;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author ZhuYX
 * @date 2021/04/07
 */
public class ByteBufferDemo {
    public static void main(String[] args) {

        // HeapByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("测试HeapByteBuffer".getBytes(StandardCharsets.UTF_8));
        //切换成读模式，position, limit, capacity.
        buffer.flip();
        System.out.println(new String(buffer.array()));

        //
        // DirectByteBuffer
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024);


    }
}
