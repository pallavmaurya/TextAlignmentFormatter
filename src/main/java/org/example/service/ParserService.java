package org.example.service;

import java.util.List;
import java.util.stream.Stream;

public interface ParserService {

    /**
     * This method returns a List of formatted String phrases
     * based on chosen Formatter implementation and width.
     * @param wordStream: stream of input words to be formatted
     * @return formatted phrase list
     */
    List<String> formatPhraseList(Stream<String> wordStream, int width);

    /**
     * This method prints the input List of Strings to standard output
     * @param formattedPhraseList : formatted phrase list to be printed to standard output
     */
    void printFormattedText(List<String> formattedPhraseList);

    /**
     * @return read from standard input and provide a stream of Strings based on pattern "\\s"
     */
    Stream<String> getWordStream();
}
