package com.tjxing.deadlock.analyzer;

import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("s", "sourcePath", true, i18n.get("args.desc.source.path"));
        options.addOption("v", "version", false, i18n.get("args.desc.version"));
        options.addOption("h", "help", false, i18n.get("args.desc.help"));

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("version")) {
                System.out.println(i18n.get("project.version"));
                return;
            }

            if (cmd.hasOption("sourcePath")) {
                String path = cmd.getOptionValue("sourcePath");
                new Analyzer(path).analyze();
                return;
            }

            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp(i18n.get("project.name"), options);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
