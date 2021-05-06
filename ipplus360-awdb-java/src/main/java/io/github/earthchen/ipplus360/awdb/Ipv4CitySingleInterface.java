package io.github.earthchen.ipplus360.awdb;

import io.github.earthchen.ipplus360.awdb.db.AWReader;
import io.github.earthchen.ipplus360.awdb.db.Metadata;
import io.github.earthchen.ipplus360.awdb.model.city.Ipv4City;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author earthchen
 * @date 2021/4/30
 **/
public interface Ipv4CitySingleInterface {

    Logger log = LoggerFactory.getLogger(Ipv4CitySingleInterface.class);

    default Ipv4City getCity(String ip) {
        if (StringUtils.isBlank(ip)) {
            return null;
        }
        try {
            InetAddress address = InetAddress.getByName(ip);
            return getCity(address);
        } catch (UnknownHostException e) {
            log.error("", e);
        }
        return null;
    }

    default Metadata getMetadata(){
        return getReader().getMetadata();
    }

    AWReader getReader();

    void setReader(AWReader awReader);

    Ipv4City getCity(InetAddress address);
}
