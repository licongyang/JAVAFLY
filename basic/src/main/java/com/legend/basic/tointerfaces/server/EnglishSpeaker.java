package com.legend.basic.tointerfaces.server;

import com.legend.basic.tointerfaces.common.ISpeaker;

public class EnglishSpeaker implements ISpeaker {
    public EnglishSpeaker() {
    }

    // region ISpeaker Members

    public void Speak() {
        System.out.println("I speak English.");
    }

    // endregion
}
