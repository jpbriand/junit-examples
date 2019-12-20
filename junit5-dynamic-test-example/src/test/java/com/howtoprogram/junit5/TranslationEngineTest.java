package com.howtoprogram.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslationEngineTest {

  private TranslatorEngine translatorEngine;

  @BeforeEach
  void setUp() {
    translatorEngine = new TranslatorEngine();
  }

  @Test
  void testTranlsateHello() {
    assertEquals("Bonjour", translatorEngine.tranlate("Hello"));
  }

  @Test
  void testTranlsateYes() {
    assertEquals("Oui", translatorEngine.tranlate("Yes"));
  }

  @Test
  void testTranlsateNo() {
    assertEquals("Non", translatorEngine.tranlate("No"));
  }

}
