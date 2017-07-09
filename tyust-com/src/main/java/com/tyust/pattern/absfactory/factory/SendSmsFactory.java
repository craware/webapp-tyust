package com.tyust.pattern.absfactory.factory;

import com.tyust.pattern.absfactory.Sender;
import com.tyust.pattern.absfactory.impl.SmsSender;

/**
 * Discription:具体工厂的实现,这个弄成单例更合适,待更新
 * Reference Resource:
 * Created by shenjp on 2017/7/9 / 23:43.
 */
public class SendSmsFactory {

    public Sender create() {
        return new SmsSender();
    }
}
