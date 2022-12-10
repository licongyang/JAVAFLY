package com.legend.basic.tointerfaces.server;

import com.legend.basic.tointerfaces.common.ISpeaker;

public abstract class Speaker implements ISpeaker {

    //region ISpeaker Members

    public abstract void Speak();

    public void SayHello() {
        System.out.println("Hello world.");
    }

    //endregion
}