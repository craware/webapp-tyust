package com.tyust.pattern.absfactory.impl;

import com.tyust.pattern.absfactory.Sender;

/**
 * Discription:具体业务实现,待续...
 * Reference Resource:
 * Created by shenjp on 2017/7/9 / 23:34.
 */
public class MailSender implements Sender {

    @Override
    public void somethingToDo() {
        System.out.println("MailSender something need to do...");
    }
}
