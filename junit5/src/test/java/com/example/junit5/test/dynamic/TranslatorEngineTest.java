package com.example.junit5.test.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslatorEngineTest {

    private TranslatorEngine translatorEngine;
    @BeforeEach
    @DisplayName("Before run test case to init resource -> TranslatorEngine")
    void init() {
        translatorEngine = new TranslatorEngine();
    }

    @Test
    public void testTranlsateHello() {
        assertEquals("Oi", translatorEngine.translate("Hello"));
    }

    @Test
    public void testTranlsateYes() {
        assertEquals("Sim", translatorEngine.translate("Yes"));
    }

    @Test
    public void testTranlsateNo() {
        assertEquals("Não", translatorEngine.translate("No"));
    }
}