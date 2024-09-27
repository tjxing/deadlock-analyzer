package com.tjxing.deadlock.analyzer.scanner;

import com.tjxing.deadlock.analyzer.i18n;
import com.tjxing.deadlock.analyzer.scanner.maven.MavenScanner;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public interface Scanner {

    List<Scanner> _scanners = Arrays.asList(
        new MavenScanner()
    );

    static Scanner get(File path) {
        for (Scanner s : _scanners) {
            if (s.accept(path)) {
                return s;
            }
        }
        throw new IllegalArgumentException(i18n.get("no.proper.project"));
    }

    boolean accept(File path);

    void scan(File path);

}
