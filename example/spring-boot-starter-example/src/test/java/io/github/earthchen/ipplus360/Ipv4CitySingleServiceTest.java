package io.github.earthchen.ipplus360;

import io.github.earthchen.ipplus360.awdb.Ipv4CitySingleInterface;
import io.github.earthchen.ipplus360.awdb.model.city.Ipv4City;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class Ipv4CitySingleServiceTest extends Ipplus360ApplicationTest {

    private static final Logger log = LoggerFactory.getLogger(Ipv4CitySingleServiceTest.class);

    @Autowired
    private Ipv4CitySingleInterface ipv4CitySingleInterface;

    @Test
    void testGetCity() {
        Ipv4City ipv4City = ipv4CitySingleInterface.getCity(getRandomIp());
        log.info("------{}", ipv4City);
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
