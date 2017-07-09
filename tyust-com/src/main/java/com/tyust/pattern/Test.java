package com.tyust.pattern;

import com.tyust.pattern.absfactory.ProviderFactory;
import com.tyust.pattern.absfactory.Sender;
import com.tyust.pattern.absfactory.factory.SendMailFactory;

/**
 * Discription:
 * Reference Resource:
 * Created by shenjp on 2017/7/9 / 23:09.
 */
public class Test {

    public static void main(String[] args) {
        ProviderFactory provider = new SendMailFactory();
        Sender sender = provider.create();
        sender.somethingToDo();
    }

}
