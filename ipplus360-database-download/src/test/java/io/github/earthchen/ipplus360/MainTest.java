package io.github.earthchen.ipplus360;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class MainTest {

    @Test
    public void testMoveIfFileExists() throws IOException {
        Files.move(
                Paths.get("/Users/earthchen/Downloads/test/aaa2.text"),
                Paths.get("/Users/earthchen/Downloads/test/aaa.txt"),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    @Test
    public void testDownload() {
        DownloadCliArgs args = new DownloadCliArgs();
        args.setDownloadId("xxx");
        args.setFilename("IP_city_single_WGS84_awdb");
        args.setDownloadPath("/Users/earthchen/Downloads/test");
        args.setTargetFilenamePath("/Users/earthchen/Downloads/test/target/IP_city_single_WGS84_awdb");
        try {
            Main.download(args, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}