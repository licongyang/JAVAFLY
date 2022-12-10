package com.legend.basic.tointerfaces.common;

import com.legend.basic.tointerfaces.server.EnglishSpeaker;
import com.legend.basic.tointerfaces.server.GermanSpeaker;
import com.legend.basic.tointerfaces.server.SpanishSpeaker;

public class SpeakerFactory {
    public static ISpeaker CreateSpeaker(Language language) {
        switch (language) {
            case English:
                return new EnglishSpeaker();
            case German:
                return new GermanSpeaker();
            case Spanish:
                return new SpanishSpeaker();
            default:
                throw new ApplicationException("No speaker can speak such language");
        }
    }
}

