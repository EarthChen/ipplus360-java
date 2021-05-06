package io.github.earthchen.ipplus360.awdb.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
@ConfigurationProperties("ipplus360")
public class Ipplus360Properties {

    private Ipv4CitySingleProperties ipv4CitySingle = new Ipv4CitySingleProperties();

    public Ipv4CitySingleProperties getIpv4CitySingle() {
        return ipv4CitySingle;
    }

    public void setIpv4CitySingle(Ipv4CitySingleProperties ipv4CitySingle) {
        this.ipv4CitySingle = ipv4CitySingle;
    }


    // private String ipv4CitySingleAwdbFilePath;

    // public String getIpv4CitySingleAwdbFilePath() {
    //     return ipv4CitySingleAwdbFilePath;
    // }
    //
    // public void setIpv4CitySingleAwdbFilePath(String ipv4CitySingleAwdbFilePath) {
    //     this.ipv4CitySingleAwdbFilePath = ipv4CitySingleAwdbFilePath;
    // }


}
