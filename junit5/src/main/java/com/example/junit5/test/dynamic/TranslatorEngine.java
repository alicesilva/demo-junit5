package com.example.junit5.test.dynamic;

import org.junit.platform.commons.util.StringUtils;

public class TranslatorEngine {

    public String translate(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("Translated text must not be empty.");
        }
        if ("Hello".equalsIgnoreCase(text)) {
            return "Oi";

        } else if ("Yes".equalsIgnoreCase(text)) {
            return "Sim";

        } else if ("No".equalsIgnoreCase(text)) {
            return "Não";

        } else if ("Goodbye".equalsIgnoreCase(text)) {
            return "Tchau";

        } else if ("Good night".equalsIgnoreCase(text)) {
            return "Boa noite";

        } else if ("Thank you".equalsIgnoreCase(text)) {
            return "Obrigado";
        } else {
            return "Not found";
        }
    }

}
