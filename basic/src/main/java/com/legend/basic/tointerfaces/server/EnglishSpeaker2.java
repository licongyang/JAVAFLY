package com.legend.basic.tointerfaces.server;

public class EnglishSpeaker2 extends Speaker {
    public EnglishSpeaker2() {
    }

    // region ISpeaker Members
    public void Speak() {
        this.SayHello();
        System.out.println("I speak English.");
    }


    // endregion
}
