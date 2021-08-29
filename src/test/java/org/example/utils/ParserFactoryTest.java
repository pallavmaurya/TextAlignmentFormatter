package org.example.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserFactoryTest {

    private ParserFactory parserFactory;

    @Before
    public void setUp(){
        parserFactory = new ParserFactory();
    }

    @Test
    public void getParserService_leftAlign() {
        assertNotNull(parserFactory.getParserService("left"));
    }

    @Test
    public void getParserService_rightAlign() {
        assertNotNull(parserFactory.getParserService("right"));
    }

    @Test
    public void getParserService_centerAlign() {
        assertNotNull(parserFactory.getParserService("center"));
    }

    @Test
    public void getParserService_justifyAlign() {
        assertNotNull(parserFactory.getParserService("justify"));
    }
    @Test
    public void getParserService_hardAlign() {
        assertNotNull(parserFactory.getParserService("hard"));
    }


}