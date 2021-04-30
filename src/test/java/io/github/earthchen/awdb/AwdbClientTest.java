package io.github.earthchen.awdb;

import io.github.earthchen.awdb.model.city.Ipv4City;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AwdbClientTest {

    AwdbClient client = new AwdbClient(new File("IP_city_single_WGS84.awdb"));

    AwdbClientTest() throws IOException {
    }

    @RepeatedTest(100)
    void getCity() {
        Ipv4City ipv4City = client.getCity(getRandomIp());
        System.out.println(ipv4City);
    }

    public String getRandomIp() {
        Random random = new Random();
        int a = random.nextInt(255);
        int b = random.nextInt(255);
        int c = random.nextInt(255);
        int d = random.nextInt(255);
        return a + "." + b + "." + c + "." + d;
    }
}