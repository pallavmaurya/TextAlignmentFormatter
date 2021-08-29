package org.example.service.impl;

import org.example.service.FormatterService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FormatterServiceHardAlignedImpl implements FormatterService {

    /**
     * TODO override and implement getPhraseList for Hard Alignment
     *
     * @param wordStream: stream of input words to be formatted
     * @param width: width of formatted output
     * @return list of unformatted phrases
     */
    @Override
    public List<String> getPhraseList(Stream<String> wordStream, int width) {
        return new ArrayList<>();
    }

    /**
     * TODO implement formatPhraseList for Hard Alignment
     * @param wordStream: stream of input words to be formatted
     * @param width: width of formatted output
     * @return
     */
    @Override
    public List<String> formatPhraseList(Stream<String> wordStream, int width) {
        return new ArrayList<>();
    }

}
