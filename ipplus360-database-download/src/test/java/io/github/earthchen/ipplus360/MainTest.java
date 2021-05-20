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

}