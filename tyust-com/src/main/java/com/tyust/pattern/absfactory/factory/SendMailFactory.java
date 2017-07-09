package com.tyust.pattern.absfactory.factory;

import com.tyust.pattern.absfactory.ProviderFactory;
import com.tyust.pattern.absfactory.Sender;
import com.tyust.pattern.absfactory.impl.MailSender;

/**
 * Discription:具体工厂的实现,这个弄成单例更合适,待更新
 * Reference Resource:
 * Created by shenjp on 2017/7/9 / 23:42.
 */
public class SendMailFactory implements ProviderFactory {
    @Override
    public Sender create() {
        return new MailSender();
    }
}
