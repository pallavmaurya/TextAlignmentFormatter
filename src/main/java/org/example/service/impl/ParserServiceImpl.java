package org.example.service.impl;

import org.example.service.FormatterService;
import org.example.service.ParserService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.example.utils.TextFormatterConstants.INPUT_DELIMITER;
import static org.example.utils.TextFormatterConstants.SPACE_DELIMITER;

public class ParserServiceImpl implements ParserService {

    private final FormatterService formatterService;

    public ParserServiceImpl(FormatterService formatterService) {
        this.formatterService = formatterService;
    }

    @Override
    public List<String> formatPhraseList(Stream<String> wordStream, int width) {
        return formatterService.formatPhraseList(wordStream, width);
    }

    @Override
    public void printFormattedText(List<String> formattedPhraseList) {
        formatterService.printFormattedPhraseList(formattedPhraseList);
    }

    @Override
    public Stream<String> getWordStream() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(INPUT_DELIMITER);
        Pattern pattern = Pattern.compile(SPACE_DELIMITER);
        Stream<String> stringStream = pattern.splitAsStream(scanner.next());
        scanner.close();
        return stringStream;
    }
}
