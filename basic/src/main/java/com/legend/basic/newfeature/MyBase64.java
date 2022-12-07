package com.legend.basic.newfeature;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * jdk7,需要第三方库进行Base64编码
 * jdk8,Base64编码已经称为JAVA类库的标准
 */
public class MyBase64 {
    public static void main(String[] args) {
        final String text = "Base64 finally in java 8!";
        // 编码encode
        final String encodeToString = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeToString);
        // 解码decode
        final String decoded = new String(Base64.getDecoder().decode(encodeToString), StandardCharsets.UTF_8);
        System.out.println(decoded);

    }
}
