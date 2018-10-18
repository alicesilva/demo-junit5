package com.example.junit5.test.dynamic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslationEngineDynamicTest {

    private TranslatorEngine translatorEngine;

    @BeforeEach
    @DisplayName("Before run test case to init resource -> TranslatorEngine")
    public void init() {
        translatorEngine = new TranslatorEngine();
    }

    public void translateDynamicTestsRaw() {

        List<String> inPhrases = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
        List<String> outPhrases = new ArrayList<>(Arrays.asList("Oi", "Sim", "Não"));
        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < inPhrases.size(); i++) {
            String phr = inPhrases.get(i);
            String outPhr = outPhrases.get(i);

            // create an test execution
            Executable exec = () -> assertEquals(outPhr, translatorEngine.translate(phr));

            // create a test display name
            String testName = "Test translate " + phr;
            // create dynamic test
            DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

            // add the dynamic test to collection
            dynamicTests.add(dTest);
        }
    }

    @TestFactory
    public Collection<DynamicTest> translateDynamicTests() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("Oi", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < inPhrases.size(); i++) {

            String phr = inPhrases.get(i);
            String outPhr = outPhrases.get(i);

            //cria executável
            Executable exec = () -> assertEquals(outPhr, translatorEngine.translate(phr));

            //associa um nome a cada teste
            String testName = "Test translate " + phr;
            
            //criando o teste dinâmico
            DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

            //adicionando o teste dinâmico na coleção
            dynamicTests.add(dTest);
        }
        return dynamicTests;
    }

    @DisplayName("Teste com erro para mostrar lançamento de exceção")
    @TestFactory
    public Stream<DynamicTest> translateDynamicTestsFromStream() {

        // set all test action to cover 100%
        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you", "Other", " "));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("Oi", "Sim", "Não", "Tchau", "Boa noite", "Obrigado", "Not found", null));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
        }));
    }

 
    @TestFactory
    public Iterable<DynamicTest> translateDynamicTestsFromIterate() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("Oi", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
        })).collect(Collectors.toList());
    }

    @TestFactory
    public Iterator<DynamicTest> translateDynamicTestsFromIterator() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("Oi", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
        })).iterator();
    }
}
