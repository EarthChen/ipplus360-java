package io.github.earthchen.ipplus360;

import cn.hutool.crypto.SecureUtil;
import io.github.earthchen.ipplus360.awdb.db.AWReader;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException, IOException, InterruptedException {
        DownloadCliArgs downloadCliArgs = CliUtils.getDownloadArgs(args);
        log.info("downloadCliArgs={}", downloadCliArgs);
        download(downloadCliArgs, 0);
        if (downloadCliArgs.getFixedDelay() > 0) {
            Thread.sleep(downloadCliArgs.getFixedDelay());
            download(downloadCliArgs, 0);
        }
    }

    /**
     * @throws IOException
     */
    private static void download(DownloadCliArgs downloadCliArgs, int times) throws IOException {
        String text = DownloadUtil.getText(Ipplus360DownloadUtils.getDownloadMd5(downloadCliArgs.getDownloadId(),
                downloadCliArgs.getFilename()));
        log.info("downloadCliArgs={} md5={}", downloadCliArgs, text);

        DownloadUtil.downloadBySync(Ipplus360DownloadUtils.getDownloadUrl(downloadCliArgs.getDownloadId(),
                downloadCliArgs.getFilename()),
                downloadCliArgs.getDownloadPath(), CliUtils.tmpDatabaseFilename);
        File downloadFile = new File(downloadCliArgs.getDownloadPath(), CliUtils.tmpDatabaseFilename);
        if (!downloadFile.exists()) {
            return;
        }
        if (!text.equals(SecureUtil.md5(downloadFile))) {
            times++;
            log.error("download times={} error md5 not equals", times);
            if (times >= 3) {
                throw new RuntimeException("download error md5 not equals");
            }
            download(downloadCliArgs, times);
        }

        AWReader awReader = new AWReader(downloadFile);
        AWReader oldReader = new AWReader(new File(downloadCliArgs.getTargetFilenamePath()));
        if (awReader.getMetadata().getBuildDate().after(oldReader.getMetadata().getBuildDate())) {
            log.info("database updated metadata={}", awReader);
            Files.move(Paths.get(downloadCliArgs.getDownloadPath(), CliUtils.tmpDatabaseFilename),
                    Paths.get(downloadCliArgs.getTargetFilenamePath()));
        }
    }
}
