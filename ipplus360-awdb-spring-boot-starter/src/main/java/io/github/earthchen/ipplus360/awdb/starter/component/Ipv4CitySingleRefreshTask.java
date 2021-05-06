package io.github.earthchen.ipplus360.awdb.starter.component;

import io.github.earthchen.ipplus360.awdb.Ipv4CitySingleInterface;
import io.github.earthchen.ipplus360.awdb.db.AWReader;
import io.github.earthchen.ipplus360.awdb.db.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class Ipv4CitySingleRefreshTask {

    private static final Logger log = LoggerFactory.getLogger(Ipv4CitySingleRefreshTask.class);

    private final String ipv4CitySingleDatabasePath;

    private final Ipv4CitySingleInterface ipv4CitySingleInterface;

    public Ipv4CitySingleRefreshTask(String ipv4CitySingleDatabasePath, Ipv4CitySingleInterface ipv4CitySingleInterface) {
        this.ipv4CitySingleDatabasePath = ipv4CitySingleDatabasePath;
        this.ipv4CitySingleInterface = ipv4CitySingleInterface;
    }

    @Scheduled(fixedDelayString = "${ipplus360.ipv4-city-single.refresh.time:21600000}")
    public void refresh() {
        log.info("refresh ipv4 city single database");
        try {
            AWReader reader = new AWReader(new File(ipv4CitySingleDatabasePath));
            Metadata newMetadata = reader.getMetadata();
            Metadata metadata = ipv4CitySingleInterface.getMetadata();
            if (newMetadata.getBuildDate().after(metadata.getBuildDate())) {
                ipv4CitySingleInterface.setReader(reader);
                log.info("refresh ipv4 city single database is updated");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
