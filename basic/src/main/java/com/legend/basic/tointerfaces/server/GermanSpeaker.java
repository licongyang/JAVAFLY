package com.legend.basic.tointerfaces.server;

import com.legend.basic.tointerfaces.common.ISpeaker;

public class GermanSpeaker implements ISpeaker {
    public GermanSpeaker() {
    }

    // region ISpeaker Members

    public void Speak() {
        System.out.println("I speak German.");
    }

    //endregion
}
