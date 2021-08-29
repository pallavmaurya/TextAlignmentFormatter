package org.example;

import org.example.service.ParserService;
import org.example.utils.ParserFactory;

import java.util.List;
import java.util.stream.Stream;

/**
 * Basic text formatter to break the input text into multiple lines of given width
 * and align as per the chosen alignment
 *
 * @author : pallavmaurya@gmail.com
 */
public class TextFormatter {

    /**
     * @param args: program arguments
     *              0: alignment
     *              1: width
     */
    public static void main(String[] args) {
        String alignment = args[0];
        int width = Integer.parseInt(args[1]);

        ParserFactory parserFactory = new ParserFactory();

        ParserService parserService = parserFactory.getParserService(alignment);

        Stream<String> wordStream = parserService.getWordStream();
        List<String> formattedPhraseList = parserService.formatPhraseList(wordStream, width);
        parserService.printFormattedText(formattedPhraseList);

    }


}
