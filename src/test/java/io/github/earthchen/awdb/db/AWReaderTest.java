package io.github.earthchen.awdb.db;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

class AWReaderTest {

    AWReader awReader = new AWReader(new File("IP_city_single_WGS84.awdb"));

    AWReaderTest() throws IOException {
    }

    @Test
    void get() throws IOException {
        InetAddress address = InetAddress.getByName("111.206.85.4");
        JsonNode node = awReader.get(address);
        System.out.println(node);

        InetAddress address2 = InetAddress.getByName("164.114.53.60");
        JsonNode node2 = awReader.get(address2);
        System.out.println(node2);
    }
}