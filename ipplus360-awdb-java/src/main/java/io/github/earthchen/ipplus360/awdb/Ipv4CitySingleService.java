package io.github.earthchen.ipplus360.awdb;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.earthchen.ipplus360.awdb.db.AWReader;
import io.github.earthchen.ipplus360.awdb.model.city.Ipv4City;
import io.github.earthchen.ipplus360.awdb.utils.AwdbJsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @author earthchen
 * @date 2021/4/30
 **/
public class Ipv4CitySingleService implements Ipv4CitySingleInterface {

    private static final Logger log = LoggerFactory.getLogger(Ipv4CitySingleService.class);

    private AWReader reader;

    public Ipv4CitySingleService(AWReader reader) {
        this.reader = reader;
        log.info("awdb metadata={}", reader.getMetadata());
    }

    public Ipv4CitySingleService(File databaseFile) throws IOException {
        this(new AWReader(databaseFile));
    }

    @Override
    public Ipv4City getCity(InetAddress address) {
        JsonNode cityNode = null;
        try {
            cityNode = reader.get(address);
        } catch (IOException e) {
            log.error("", e);
        }
        return AwdbJsonUtils.nodeToBean(cityNode, Ipv4City.class);
    }

    @Override
    public AWReader getReader() {
        return reader;
    }

    @Override
    public void setReader(AWReader reader) {
        this.reader = reader;
    }

}
