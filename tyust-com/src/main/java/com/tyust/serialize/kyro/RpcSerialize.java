package com.tyust.serialize.kyro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Discription:
 * Reference Resource:序列化接口
 * Created by shenjp on 2017/6/27 / 22:14.
 */
public interface RpcSerialize {

    void serialize(OutputStream output, Object object) throws IOException;

    Object deserialize(InputStream input) throws IOException;
}
