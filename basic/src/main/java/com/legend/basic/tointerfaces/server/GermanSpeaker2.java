package com.legend.basic.tointerfaces.server;

public class GermanSpeaker2 extends Speaker {
    public GermanSpeaker2() {
    }

    // region ISpeaker Members

    public void Speak() {
        System.out.println("I speak German.");
        this.SayHello();
    }

    //endregion
}
