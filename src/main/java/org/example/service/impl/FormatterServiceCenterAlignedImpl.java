package org.example.service.impl;

import org.example.service.FormatterService;
import org.example.utils.TextFormatterConstants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatterServiceCenterAlignedImpl implements FormatterService {

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
            for (int i = 0; i < ((width - phrase.length()) / 2); i++) {
                spaces.append(TextFormatterConstants.SPACE);
            }
            phrase = spaces + phrase + spaces;

            if (((width - phrase.length()) % 2) == 1) {
                phrase = phrase + TextFormatterConstants.SPACE;
            }
        }
        return phrase;
    }
}
