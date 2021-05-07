package io.github.earthchen.ipplus360;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class CliUtils {

    public static Options getDownloadOptions() {
        Options options = new Options();
        Option downloadIdOption = new Option(downloadIdOpt, "downloadId", true, "downloadId");
        downloadIdOption.setRequired(true);
        Option downloadFilenameOption = new Option(downloadFilenameOpt, "downloadFilename", true, "downloadFilename");
        downloadFilenameOption.setRequired(true);
        Option downloadPathOption = new Option(downloadPathOpt, "downloadPath", true, "downloadPath");
        Option targetPathOption = new Option(targetPathOpt, "targetPath", true, "targetPath");
        targetPathOption.setRequired(true);

        Option fixDelayOption = new Option(fixDelayOpt, "fixDelay", true, "fixDelay");

        Option databaseTypeOption = new Option(databaseTypeOpt, "databaseType", true, "databaseType");
        options.addOption(downloadIdOption);
        options.addOption(downloadFilenameOption);
        options.addOption(downloadPathOption);
        options.addOption(targetPathOption);
        options.addOption(fixDelayOption);
        options.addOption(databaseTypeOption);
        return options;
    }

    public static final Options downloadOptions = getDownloadOptions();

    public static final CommandLineParser parser = new DefaultParser();

    public static final String downloadIdOpt = "i";
    public static final String downloadFilenameOpt = "f";
    public static final String downloadPathOpt = "p";
    public static final String targetPathOpt = "t";
    public static final String fixDelayOpt = "d";
    public static final String databaseTypeOpt = "b";

    public static final String tmpDatabaseFilename = "database.zip";

    public static DownloadCliArgs getDownloadArgs(String[] args) throws ParseException {
        DownloadCliArgs downloadCliArgs = new DownloadCliArgs();
        CommandLine commandLine = parser.parse(downloadOptions, args);
        downloadCliArgs.setDownloadId(commandLine.getOptionValue(downloadIdOpt));
        downloadCliArgs.setFilename(commandLine.getOptionValue(downloadFilenameOpt));
        downloadCliArgs.setDownloadPath(commandLine.getOptionValue(downloadPathOpt, "/tmp"));
        downloadCliArgs.setTargetFilenamePath(commandLine.getOptionValue(targetPathOpt));
        return downloadCliArgs;
    }
}
