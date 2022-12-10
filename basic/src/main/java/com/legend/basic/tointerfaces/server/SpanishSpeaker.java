package com.legend.basic.tointerfaces.server;

import com.legend.basic.tointerfaces.common.ISpeaker;

public class SpanishSpeaker implements ISpeaker {

    public SpanishSpeaker() {
    }

    //region ISpeaker Members

    public void Speak() {
        System.out.println("I speak Spanish.");
    }

    // endregion
}