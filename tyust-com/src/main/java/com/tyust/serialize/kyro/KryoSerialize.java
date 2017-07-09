package com.tyust.serialize.kyro;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoPool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Discription:
 * Reference Resource:
 * Created by shenjp on 2017/6/27 / 22:16.
 */
public class KryoSerialize implements RpcSerialize {

    private KryoPool pool = null;

    public KryoSerialize(final KryoPool pool) {
        this.pool = pool;
    }

    /**
     * kryo序列化
     * @param output
     * @param object
     * @throws IOException
     */
    @Override
    public void serialize(OutputStream output, Object object) throws IOException {
        Kryo kryo = pool.borrow();
        Output out = new Output(output);
        kryo.writeClassAndObject(out, object);
        out.close();
        output.close();
        pool.release(kryo);
    }

    /**
     * kryo反序列化
     * @param input
     * @return
     * @throws IOException
     */
    @Override
    public Object deserialize(InputStream input) throws IOException {
        Kryo kryo = pool.borrow();
        Input in = new Input(input);
        Object object = kryo.readClassAndObject(in);
        in.close();
        input.close();
        pool.release(kryo);
        return object;
    }
}
