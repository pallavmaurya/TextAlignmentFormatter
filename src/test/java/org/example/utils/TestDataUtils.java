package org.example.utils;

import java.util.stream.Stream;

public class TestDataUtils {

    public static Stream<String> getWordStream(){
        return Stream.of("This", "text", "should", "be", "left", "aligned");
    }
}
