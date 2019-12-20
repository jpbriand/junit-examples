package com.howtoprogram.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslationEngineDynamicTest {

  private TranslatorEngine translatorEngine;

  @BeforeEach
  void setUp() {
    translatorEngine = new TranslatorEngine();
  }

  @TestFactory
  Stream<DynamicTest> translateDynamicTestsFromStream() {

    List<String> inPhrases =
        new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
    List<String> outPhrases =
        new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

    return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
      int idx = inPhrases.indexOf(phrs);
      assertEquals(outPhrases.get(idx), translatorEngine.tranlate(phrs));
    }));
  }
}
