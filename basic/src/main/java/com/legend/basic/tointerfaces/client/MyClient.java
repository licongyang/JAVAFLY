package com.legend.basic.tointerfaces.client;

import com.legend.basic.tointerfaces.common.Language;
import com.legend.basic.tointerfaces.common.ISpeaker;
import com.legend.basic.tointerfaces.common.SpeakerFactory;

public class MyClient {

    public static void main(String[] args) {
        // 通过speakfactor获取ispeaker实例
        final ISpeaker iSpeaker = SpeakerFactory.CreateSpeaker(Language.English);
        iSpeaker.Speak();
    }
}
