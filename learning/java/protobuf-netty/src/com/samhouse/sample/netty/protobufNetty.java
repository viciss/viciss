package com.samhouse.sample.netty;

import com.google.protobuf.InvalidProtocolBufferException;
import com.samhouse.sample.netty.codec.protobuf.SubscribeReqProto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangs22 on 2017/8/4.
 */
public class protobufNetty {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body)
            throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder =
                SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("test");
        builder.setProductName("Netty book");
        List<String> address = new ArrayList<>();
        address.add("Address 1");
        address.add("Address 2");
        address.add("Address 3");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args)
        throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode: " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode: " + req2.toString());
        System.out.println("Assert equal: " + req2.equals(req));
    }
}
