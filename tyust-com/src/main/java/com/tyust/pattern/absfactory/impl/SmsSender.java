package com.tyust.pattern.absfactory.impl;

import com.tyust.pattern.absfactory.Sender;

/**
 * Discription:具体业务实现,待续...
 * Reference Resource:
 * Created by shenjp on 2017/7/9 / 23:35.
 */
public class SmsSender implements Sender {
    @Override
    public void somethingToDo() {
        System.out.println("SmsSender something need to do...");
    }
}
