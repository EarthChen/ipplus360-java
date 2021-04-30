package io.github.earthchen.awdb;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.earthchen.awdb.db.AWReader;
import io.github.earthchen.awdb.model.city.Ipv4City;
import io.github.earthchen.awdb.utils.AwdbJsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @author earthchen
 * @date 2021/4/30
 **/
public class AwdbClient implements Ipv4CitySingleInterface {

    private static final Logger log = LoggerFactory.getLogger(AwdbClient.class);

    private AWReader reader;

    public AwdbClient(AWReader reader) {
        this.reader = reader;
    }

    public AwdbClient(File databaseFile) throws IOException {
        this.reader = new AWReader(databaseFile);
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

    public void setReader(AWReader reader) {
        this.reader = reader;
    }

}
