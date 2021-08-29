package org.example.service;

import org.example.utils.TextFormatterConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static org.example.utils.TextFormatterConstants.BLANK_STRING;

public interface FormatterService {

    /**
     * This method returns a List of formatted String phrases
     * based on chosen Formatter implementation and width.
     * @param wordStream: stream of input words to be formatted
     * @return formatted phrase list
     */
    List<String> formatPhraseList(Stream<String> wordStream, int width);


    /**
     * This method returns a List of String phrases based on width.
     * @param wordStream: stream of input words to be formatted
     * @return List of unformatted phrases based on width
     */
    default List<String> getPhraseList(Stream<String> wordStream, int width) {
        AtomicReference<String> phrase = new AtomicReference<>(BLANK_STRING);
        List<String> phraseList = new ArrayList<>();
        wordStream.forEach(word -> {
            if ((phrase.get().length() + word.length()) <= width) {
                phrase.set(phrase.get() + word + TextFormatterConstants.SPACE);
            } else if (word.length() >= (width - 1)) {
                phrase.set(word);
                phraseList.add(phrase.get().trim());
            } else {
                phraseList.add(phrase.get().trim());
                phrase.set(word + TextFormatterConstants.SPACE);
            }
        });
        wordStream.close();
        phraseList.add(phrase.get().trim());
        return phraseList;
    }


    /**
     * This method prints the input List of Strings to standard output
     * @param formattedPhraseList : formatted phrase list to be printed to standard output
     */
    default void printFormattedPhraseList(List<String> formattedPhraseList) {
        formattedPhraseList.forEach(System.out::println);
    }
}
