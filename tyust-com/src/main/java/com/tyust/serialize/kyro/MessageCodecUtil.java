package com.tyust.serialize.kyro;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Discription:
 * Reference Resource:
 * Created by shenjp on 2017/6/27 / 22:11.
 */
public interface MessageCodecUtil {

    void encode(final ByteBuf out, final Object message) throws IOException;

    Object decode(byte[] body) throws IOException;
}
