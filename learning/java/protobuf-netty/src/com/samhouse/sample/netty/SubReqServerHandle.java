package com.samhouse.sample.netty;

import com.samhouse.sample.netty.codec.protobuf.SubscribeReqProto;
import com.samhouse.sample.netty.codec.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by huangs22 on 2017/8/4.
 */

@ChannelHandler.Sharable
public class SubReqServerHandle extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception {
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if ("test".equalsIgnoreCase(req.getUserName())) {
            System.out.println("Service accept client subscribe req: [" + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }
        ReferenceCountUtil.release(msg);
    }

    private SubscribeRespProto.SubscribeResp resp(int subReqID) {
        SubscribeRespProto.SubscribeResp.Builder builder =
                SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setRespCode(0);
        builder.setDesc("Netty book order succeed, 3 days later.");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
