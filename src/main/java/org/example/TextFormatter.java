package org.example;

import org.example.utils.TextFormatterConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.utils.TextFormatterConstants.*;

/**
 * Basic text formatter to break the input text into multiple lines of given width
 * and align as per the chosen alignment
 * @author : pallavmaurya@gmail.com
 */
public class TextFormatter
{

    static String alignment;
    static int width;

    /**
     * @param args: program arguments
     *            0: alignment
     *            1: width
     */
    public static void main(String[] args) {
        alignment = args[0];
        width = Integer.parseInt(args[1]);

        Stream<String> wordStream = getWordStream();
        List<String> phraseList = getPhraseList(wordStream);
        List<String> formattedPhraseList = formatPhraseList(phraseList);
        formattedPhraseList.forEach(System.out::println);
    }

    /**
     * @param phraseList: input phrase list to be formatted
     * @return formatted phrase list
     */
    static List<String> formatPhraseList(List<String> phraseList) {
        return phraseList.stream()
                .map(TextFormatter::alignPhrase)
                .collect(Collectors.toList());
    }

    /**
     * @return read from standard input and provide a stream of Strings based on pattern "\\s"
     */
    static Stream<String> getWordStream() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(INPUT_DELIMITER);
        Pattern pattern = Pattern.compile(SPACE_DELIMITER);
        Stream<String> stringStream = pattern.splitAsStream(scanner.next());
        scanner.close();
        return stringStream;
    }

    /**
     * @param wordStream: stream of strings from input text
     * @return phrase list based on width
     */
    static List<String> getPhraseList(Stream<String> wordStream) {
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
     * @param phrase: input phrase to be aligned as per alignment
     * @return aligned phrase
     */
    static String alignPhrase(String phrase) {
        StringBuilder spaces = new StringBuilder();
        if (phrase.length() <= width) {
            switch (alignment) {
                case RIGHT_ALIGNED:

                    for (int i = 0; i < (width - phrase.length()); i++) {
                        spaces.append(TextFormatterConstants.SPACE);
                    }
                    phrase = spaces + phrase;
                    break;

                case LEFT_ALIGNED:

                    for (int i = 0; i < (width - phrase.length()); i++) {
                        spaces.append(TextFormatterConstants.SPACE);
                    }
                    phrase = phrase + spaces;
                    break;

                case CENTER:

                    for (int i = 0; i < ((width - phrase.length()) / 2); i++) {
                        spaces.append(TextFormatterConstants.SPACE);
                    }
                    phrase = spaces + phrase + spaces;

                    if (((width - phrase.length()) % 2) == 1) {
                        phrase = phrase + TextFormatterConstants.SPACE;
                    }
                    break;

                case JUSTIFY:

                case HARD:
                    //todo
                    break;

                default:
                    return phrase;
            }
        }
        return phrase;
    }
}
