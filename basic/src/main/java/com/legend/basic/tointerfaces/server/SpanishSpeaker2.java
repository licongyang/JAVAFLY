package com.legend.basic.tointerfaces.server;


import com.legend.basic.tointerfaces.common.ApplicationException;

public class SpanishSpeaker2 extends Speaker {

    public SpanishSpeaker2() {
    }

    //region ISpeaker Members

    public void Speak() {
        System.out.println("I speak Spanish.");
    }

    @Override
    public void SayHello() {
        throw  new ApplicationException("I cannot say Hello World.");
    }



    // endregion
}