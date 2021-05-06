package io.github.earthchen.ipplus360.awdb.starter;

import io.github.earthchen.ipplus360.awdb.Ipv4CitySingleInterface;
import io.github.earthchen.ipplus360.awdb.Ipv4CitySingleService;
import io.github.earthchen.ipplus360.awdb.db.AWReader;
import io.github.earthchen.ipplus360.awdb.starter.component.Ipv4CitySingleRefreshTask;
import io.github.earthchen.ipplus360.awdb.starter.config.Ipplus360Properties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.io.IOException;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
@Configuration
@EnableScheduling
@EnableConfigurationProperties(Ipplus360Properties.class)
public class Ipplus360AwdbAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public AWReader ipv4CitySingleAwdbReader(Ipplus360Properties properties) throws IOException {
        return new AWReader(new File(properties.getIpv4CitySingle().getDatabasePath()));
    }

    @Bean
    @ConditionalOnMissingBean
    public Ipv4CitySingleInterface ipv4CitySingleService(AWReader ipv4CitySingleAwdbReader) {
        return new Ipv4CitySingleService(ipv4CitySingleAwdbReader);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "ipplus360.ipv4-city-single.refresh", value = "enabled",
            havingValue = "true", matchIfMissing = false)
    public Ipv4CitySingleRefreshTask ipv4CitySingleRefreshTask(Ipv4CitySingleInterface ipv4CitySingleInterface,
                                                               Ipplus360Properties properties) {
        return new Ipv4CitySingleRefreshTask(properties.getIpv4CitySingle().getDatabasePath(), ipv4CitySingleInterface);
    }
}
