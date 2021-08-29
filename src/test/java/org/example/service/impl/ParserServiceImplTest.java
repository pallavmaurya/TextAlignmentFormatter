package org.example.service.impl;

import org.example.service.FormatterService;
import org.example.utils.TestDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParserServiceImplTest {

    @Mock
    private FormatterService formatterService;

    @InjectMocks
    private ParserServiceImpl parserService;

    List<String> formattedPhraseList;
    Stream<String> wordStream;

    @Before
    public void setUp(){
        wordStream = Stream.<String>builder().build();
        formattedPhraseList = new ArrayList<>();
        formattedPhraseList.add("This text");
        formattedPhraseList.add("should be");
        formattedPhraseList.add("left");
        formattedPhraseList.add("aligned");

        when(formatterService.formatPhraseList(wordStream,10)).thenReturn(formattedPhraseList);


        String input = "This text should be left aligned ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void formatPhraseList() {
        assertEquals("formattedPhraseList not matched", formattedPhraseList
                , parserService.formatPhraseList(wordStream, 10));
    }

    @Test
    public void printFormattedText() {
        parserService.printFormattedText(formattedPhraseList);
        verify(formatterService,times(1)).printFormattedPhraseList(formattedPhraseList);
    }

    @Test
    public void getWordStream() {
        assertEquals(TestDataUtils.getWordStream().collect(Collectors.toList()),
                parserService.getWordStream().collect(Collectors.toList()));
    }
}