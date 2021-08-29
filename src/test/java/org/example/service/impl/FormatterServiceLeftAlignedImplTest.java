package org.example.service.impl;

import org.example.utils.TestDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FormatterServiceLeftAlignedImplTest {

    @InjectMocks
    private FormatterServiceLeftAlignedImpl formatterService;

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

        assertEquals("Alignment should be correct", "This text ",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(0));
        assertEquals("Alignment should be correct", "should be ",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(1));
        assertEquals("Alignment should be correct", "left      ",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(2));
        assertEquals("Alignment should be correct", "aligned   ",
                formatterService.formatPhraseList(TestDataUtils.getWordStream(), 10).get(3));
    }
}