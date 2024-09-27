package com.tjxing.deadlock.analyzer.scanner.maven;

import com.tjxing.deadlock.analyzer.i18n;
import com.tjxing.deadlock.analyzer.scanner.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Paths;

public class MavenScanner implements Scanner {

    private final static Logger log = LoggerFactory.getLogger(MavenScanner.class);

    @Override
    public boolean accept(File path) {
        File pomXML = Paths.get(path.getAbsolutePath(), "pom.xml").toFile();
        if (pomXML.exists() && pomXML.canRead() && pomXML.isFile()) {
            log.info(i18n.get("maven.project.found", pomXML.getAbsolutePath()));
            return true;
        }
        return false;
    }

    @Override
    public void scan(File path) {
        File f = Paths.get(path.getAbsolutePath(), "pom.xml").toFile();
        PomXML pomXML = PomXMLParser.parse(f);
    }

}
