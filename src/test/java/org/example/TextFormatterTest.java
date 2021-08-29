package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TextFormatterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        String input = "This text should be right aligned ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void integrationTestRightAlign10() {

        final String expected = " This text\r\n" +
                                " should be\r\n" +
                                "     right\r\n" +
                                "   aligned\r\n";

        TextFormatter.main(new String[]{"right", "10"});
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void integrationTestRightAlign20() {

        final String expected = " This text should be\r\n" +
                                "       right aligned\r\n";

        TextFormatter.main(new String[]{"right", "20"});
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void integrationTestLeftAlign10() {

        final String expected = "This text \r\n" +
                                "should be \r\n" +
                                "right     \r\n" +
                                "aligned   \r\n";

        TextFormatter.main(new String[]{"left", "10"});
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void integrationTestLeftAlign20() {

        final String expected = "This text should be \r\n" +
                                "right aligned       \r\n";

        TextFormatter.main(new String[]{"left", "20"});
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void integrationTestCenterAlign10() {

        final String expected = "This text \r\n" +
                "should be \r\n" +
                "  right   \r\n" +
                " aligned  \r\n";

        TextFormatter.main(new String[]{"center", "10"});
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void integrationTestCenterAlign20() {

        final String expected = "This text should be \r\n" +
                                "   right aligned    \r\n";

        TextFormatter.main(new String[]{"center", "20"});
        assertEquals(expected, outputStreamCaptor.toString());
    }



}