package org.example.service.impl;

import org.example.utils.TestDataUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FormatterServiceRightAlignedImplTest {

    @InjectMocks
    private FormatterServiceRightAlignedImpl formatterService;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void getPhraseList() {

        assertEquals("Alignment should be correct", "This text",
                formatterService.getPhraseList(TestDataUtils.getWordStream(), 10).get(0));
        assertEquals("Alignment should be correct", "should be",
                formatterService.getPhraseList(TestDataUtils.getWordStream(), 10).get(1));
        assertEquals("Alignment should be correct", "left",
                formatterService.getPhraseList(TestDataUtils.getWordStream(), 10).get(2));
        assertEquals("Alignment should be correct", "aligned",
                formatterService.getPhraseList(TestDataUtils.getWordStream(), 10).get(3));
    }

    @Test
    public void formatPhraseList() {

        assertEquals("Alignment should be correct", " This text",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(0));
        assertEquals("Alignment should be correct", " should be",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(1));
        assertEquals("Alignment should be correct", "      left",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(2));
        assertEquals("Alignment should be correct", "   aligned",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(3));
    }

    @Test
    public void printFormattedPhraseList() {
        List<String> formattedPhraseList = new ArrayList<>();
        formattedPhraseList.add(" This text");
        formattedPhraseList.add(" should be");
        formattedPhraseList.add("     right");
        formattedPhraseList.add("   aligned");
        formatterService.printFormattedPhraseList(formattedPhraseList);
        final String expected = " This text\r\n" +
                                " should be\r\n" +
                                "     right\r\n" +
                                "   aligned\r\n";
        assertEquals(expected, outputStreamCaptor.toString());
    }

}