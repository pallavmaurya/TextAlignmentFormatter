package org.example.service.impl;

import org.example.utils.TestDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FormatterServiceCenterAlignedImplTest {

    @InjectMocks
    private FormatterServiceRightAlignedImpl formatterService;

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
}