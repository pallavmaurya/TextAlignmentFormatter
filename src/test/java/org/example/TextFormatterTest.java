package org.example;

import org.example.utils.TextFormatterConstants;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class TextFormatterTest {

    @Before
    public void setUp() {
        TextFormatter.alignment = TextFormatterConstants.LEFT_ALIGNED;
        TextFormatter.width = 10;
        String input = "This text should be left aligned ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


    @Test
    public void formatPhraseList() {
        List<String> inputList = new ArrayList<>();
        inputList.add("This text");
        inputList.add("should be");
        inputList.add("left");
        inputList.add("aligned");

        assertEquals("Alignment should be correct", "This text ",
                TextFormatter.formatPhraseList(inputList).get(0));
        assertEquals("Alignment should be correct", "should be ",
                TextFormatter.formatPhraseList(inputList).get(1));
        assertEquals("Alignment should be correct", "left      ",
                TextFormatter.formatPhraseList(inputList).get(2));
        assertEquals("Alignment should be correct", "aligned   ",
                TextFormatter.formatPhraseList(inputList).get(3));
    }

    @Test
    public void getWordStream() {
        assertEquals(Stream.of("This", "text", "should", "be", "left", "aligned").collect(Collectors.toList()),
                TextFormatter.getWordStream().collect(Collectors.toList()));
    }

    @Test
    public void getPhraseList() {
        List<String> inputList = new ArrayList<>();
        inputList.add("This");
        inputList.add("text");
        inputList.add("should");
        inputList.add("be");
        inputList.add("left");
        inputList.add("aligned");

        assertEquals("Alignment should be correct", "This text",
                TextFormatter.getPhraseList(inputList.stream()).get(0));
        assertEquals("Alignment should be correct", "should be",
                TextFormatter.getPhraseList(inputList.stream()).get(1));
        assertEquals("Alignment should be correct", "left",
                TextFormatter.getPhraseList(inputList.stream()).get(2));
        assertEquals("Alignment should be correct", "aligned",
                TextFormatter.getPhraseList(inputList.stream()).get(3));
    }

    @Test
    public void alignPhrase_Left() {
        TextFormatter.alignment = TextFormatterConstants.LEFT_ALIGNED;
        TextFormatter.width = 10;
        assertEquals("Alignment should be correct", "This text ", TextFormatter.alignPhrase("This text"));
        assertEquals("Alignment should be correct", "should be ", TextFormatter.alignPhrase("should be"));
        assertEquals("Alignment should be correct", "left      ", TextFormatter.alignPhrase("left"));
        assertEquals("Alignment should be correct", "aligned   ", TextFormatter.alignPhrase("aligned"));

        TextFormatter.alignment = TextFormatterConstants.LEFT_ALIGNED;
        TextFormatter.width = 20;
        assertEquals("Alignment should be correct", "This text           ",
                TextFormatter.alignPhrase("This text"));
        assertEquals("Alignment should be correct", "should be           ",
                TextFormatter.alignPhrase("should be"));
        assertEquals("Alignment should be correct", "left                ",
                TextFormatter.alignPhrase("left"));
        assertEquals("Alignment should be correct", "aligned             ",
                TextFormatter.alignPhrase("aligned"));

    }

    @Test
    public void alignPhrase_Right() {
        TextFormatter.alignment = TextFormatterConstants.RIGHT_ALIGNED;
        TextFormatter.width = 10;
        assertEquals("Alignment should be correct", " This text", TextFormatter.alignPhrase("This text"));
        assertEquals("Alignment should be correct", " should be", TextFormatter.alignPhrase("should be"));
        assertEquals("Alignment should be correct", "     right", TextFormatter.alignPhrase("right"));
        assertEquals("Alignment should be correct", "   aligned", TextFormatter.alignPhrase("aligned"));

        TextFormatter.alignment = TextFormatterConstants.RIGHT_ALIGNED;
        TextFormatter.width = 20;
        assertEquals("Alignment should be correct", "           This text",
                TextFormatter.alignPhrase("This text"));
        assertEquals("Alignment should be correct", "           should be",
                TextFormatter.alignPhrase("should be"));
        assertEquals("Alignment should be correct", "               right",
                TextFormatter.alignPhrase("right"));
        assertEquals("Alignment should be correct", "             aligned",
                TextFormatter.alignPhrase("aligned"));

    }

    @Test
    public void alignPhrase_Center() {
        TextFormatter.alignment = TextFormatterConstants.CENTER;
        TextFormatter.width = 10;
        assertEquals("Alignment should be correct", "This text ", TextFormatter.alignPhrase("This text"));
        assertEquals("Alignment should be correct", "should be ", TextFormatter.alignPhrase("should be"));
        assertEquals("Alignment should be correct", "   left   ", TextFormatter.alignPhrase("left"));
        assertEquals("Alignment should be correct", " aligned  ", TextFormatter.alignPhrase("aligned"));

        TextFormatter.alignment = TextFormatterConstants.CENTER;
        TextFormatter.width = 20;
        assertEquals("Alignment should be correct", "     This text      ",
                TextFormatter.alignPhrase("This text"));
        assertEquals("Alignment should be correct", "     should be      ",
                TextFormatter.alignPhrase("should be"));
        assertEquals("Alignment should be correct", "       center       ",
                TextFormatter.alignPhrase("center"));
        assertEquals("Alignment should be correct", "      aligned       ",
                TextFormatter.alignPhrase("aligned"));

    }
}