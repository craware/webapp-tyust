package com.tyust.serialize.kyro;

import com.esotericsoftware.kryo.pool.KryoPool;
import io.netty.buffer.ByteBuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Discription:
 * Reference Resource:
 * Created by shenjp on 2017/6/27 / 22:11.
 */
public class KryoCodecUtil implements MessageCodecUtil {
    private KryoPool pool;

    public KryoCodecUtil(KryoPool pool) {
        this.pool = pool;
    }

    @Override
    public void encode(ByteBuf out, Object message)  {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try{
            byteArrayOutputStream = new ByteArrayOutputStream();
            KryoSerialize kryoSerialization = new KryoSerialize(pool);
            kryoSerialization.serialize(byteArrayOutputStream, message);
            byte[] body = byteArrayOutputStream.toByteArray();
            int dataLength = body.length;
            out.writeInt(dataLength);
            out.writeBytes(body);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * kryoj解码
     * @param body
     * @return
     */
    @Override
    public Object decode(byte[] body)  {
        ByteArrayInputStream byteArrayInputStream =null;
        try{
            byteArrayInputStream = new ByteArrayInputStream(body);
            KryoSerialize kryoSerialization = new KryoSerialize(pool);
            Object obj = kryoSerialization.deserialize(byteArrayInputStream);
            return obj;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (byteArrayInputStream != null){
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
