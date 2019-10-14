package com.example.app.controller.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 客户端通道请求处理器
 */
@Component
public class NettyChannelHandler extends ChannelInitializer<SocketChannel> {

    @Resource
    private NettyServerBusinessHandler nettyServerBusinessHandler;

    /**
     * 初始化通道配置
     * @param socketChannel 客户端通道
     * @throws Exception
     */
    public void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("decoder", new HttpRequestDecoder())   // 1
                                .addLast("encoder", new HttpResponseEncoder())  // 2
                                .addLast("aggregator", new HttpObjectAggregator(2048 * 2048))    // 3 receive buff
                                .addLast(new ChunkedWriteHandler())
                                .addLast("handler", nettyServerBusinessHandler);  // 业务
    }
}