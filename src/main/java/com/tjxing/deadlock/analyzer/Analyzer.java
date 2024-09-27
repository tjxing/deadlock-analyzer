package com.tjxing.deadlock.analyzer;

import com.tjxing.deadlock.analyzer.scanner.Scanner;

import java.io.File;

public class Analyzer {

    private final File srcPath;

    protected Analyzer(String path) {
        this.srcPath = validate(path);

    }

    private File validate(String path) {
        File f = new File(path);
        if (!f.exists() || !f.canRead() || !f.isDirectory()) {
            throw new IllegalArgumentException(i18n.get("no.source.path"));
        }
        return f;
    }

    protected void analyze() {
        Scanner.get(srcPath).scan(srcPath);
    }

}
