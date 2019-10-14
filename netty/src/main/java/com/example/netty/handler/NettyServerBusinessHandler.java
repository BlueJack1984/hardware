package com.example.netty.handler;

import com.iot.service.interfaces.AutoAPNBusinessService;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.AsciiString;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理autoAPN的后台业务代码
 * 业务逻辑入口
 * @author lushusheng
 * @Date 2019-08-30
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class NettyServerBusinessHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    //设置日期格式
    private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;

    @Resource
    private AutoAPNBusinessService autoAPNBusinessService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        FullHttpRequest request = (FullHttpRequest) msg;
        try {
            int length = request.content().readableBytes();
            String message = request.content().toString();
            log.info("++++++++++++++++++++++++++++++++++++Received http request++++++++++++++++++++++++++++++++++++++++");
            log.info("在时间点：" + SDF.format(new Date()) + "<----->消息实体内容：" + message + "<----->消息实体长度：" + length);
            //获得查询字符串(get)
            byte[] contentBytes = null;
            if(length > 0){
                contentBytes = new byte[length];
                request.content().readBytes(contentBytes);
            }
            String content = null;
            try {
                content = new String(contentBytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.info("请求信息无法转化为字符串！");
                e.printStackTrace();
            }
            //这里调用service服务
            String responseXML = autoAPNBusinessService.handleAutoAPNBusiness(content);
            //判断返回的数据是否可用
            if(StringUtils.isEmpty(responseXML)) {
                log.info("参数处理错误，获取的responseXML内容响应为空！");
                responseXML = "业务处理后得到返回数据为空，返回此字符串提示！";
            }
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(responseXML.getBytes())); // 2
            HttpHeaders heads = response.headers();
            heads.add(HttpHeaderNames.CONTENT_TYPE, contentType + "; charset=UTF-8");
            heads.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes() + ""); // 3
            heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            // 注意必须在使用完之后，close channel
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }finally {
            request.release();
        }
    }
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }
}