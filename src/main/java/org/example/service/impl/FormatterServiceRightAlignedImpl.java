package org.example.service.impl;

import org.example.service.FormatterService;
import org.example.utils.TextFormatterConstants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatterServiceRightAlignedImpl implements FormatterService {

    @Override
    public List<String> formatPhraseList(Stream<String> wordStream, int width) {
        return getPhraseList(wordStream, width)
                .stream()
                .map(phrase -> formatPhrase(phrase, width))
                .collect(Collectors.toList());
    }

    private String formatPhrase(String phrase, int width) {
        StringBuilder spaces = new StringBuilder();
        if (phrase.length() <= width) {
            for (int i = 0; i < (width - phrase.length()); i++) {
                spaces.append(TextFormatterConstants.SPACE);
            }
            phrase = spaces + phrase;
        }
        return phrase;
    }

}
