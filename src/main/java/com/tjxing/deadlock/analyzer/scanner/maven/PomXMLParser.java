package com.tjxing.deadlock.analyzer.scanner.maven;

import com.tjxing.deadlock.analyzer.i18n;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

class PomXMLParser {

    private final static Logger log = LoggerFactory.getLogger(PomXMLParser.class);

    public static PomXML parse(File f) {
        try {
            PomXML.Builder builder = new PomXML.Builder();
            SAXParserFactory.newInstance().newSAXParser()
                .parse(f, new PomXMLHandler(builder));
            return builder.build();
        } catch (IOException | SAXException | ParserConfigurationException e) {
            log.error(i18n.get("pom.xml.parse.error"), e);
            throw new IllegalStateException(e);
        }
    }

    private static class PomXMLHandler extends DefaultHandler {
        private final PomXML.Builder builder;

        PomXMLHandler(PomXML.Builder builder) {
            this.builder = builder;
        }
    }

}
