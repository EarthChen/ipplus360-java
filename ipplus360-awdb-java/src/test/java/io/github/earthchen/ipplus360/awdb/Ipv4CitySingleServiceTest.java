package io.github.earthchen.ipplus360.awdb;

import io.github.earthchen.ipplus360.awdb.model.city.Ipv4City;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

class Ipv4CitySingleServiceTest {

    Ipv4CitySingleService ipv4CitySingleService = new Ipv4CitySingleService(new File("../IP_city_single_WGS84.awdb"));

    Ipv4CitySingleServiceTest() throws IOException {
    }

    @Test
    void getCity() {
        Ipv4City ipv4City = ipv4CitySingleService.getCity(getRandomIp());
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