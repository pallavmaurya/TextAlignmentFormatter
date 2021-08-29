package org.example.utils;

import org.example.service.ParserService;
import org.example.service.impl.*;

import static org.example.utils.TextFormatterConstants.*;

/**
 * This is the factory class for ParserService
 */
public class ParserFactory {

    /**
     * @param alignment : alignment chosen by the user
     * @return ParserService implementation as per chosen alignment
     */
    public ParserService getParserService(String alignment) {
        ParserService parserService;
        switch (alignment) {
            case RIGHT_ALIGNED:
                parserService = new ParserServiceImpl(new FormatterServiceRightAlignedImpl());
                break;
            case LEFT_ALIGNED:
                parserService = new ParserServiceImpl(new FormatterServiceLeftAlignedImpl());
                break;
            case CENTER:
                parserService = new ParserServiceImpl(new FormatterServiceCenterAlignedImpl());
                break;
            case JUSTIFY:
                parserService = new ParserServiceImpl(new FormatterServiceJustifyAlignedImpl());
                break;
            case HARD:
                parserService = new ParserServiceImpl(new FormatterServiceHardAlignedImpl());
                break;
            default:
                parserService = new ParserServiceImpl(new FormatterServiceRightAlignedImpl());
                break;
        }
        return parserService;
    }
}
