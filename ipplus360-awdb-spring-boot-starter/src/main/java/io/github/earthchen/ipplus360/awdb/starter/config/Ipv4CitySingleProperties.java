package io.github.earthchen.ipplus360.awdb.starter.config;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class Ipv4CitySingleProperties {

    private String databasePath;

    private RefreshProperties refresh = new RefreshProperties();

    public String getDatabasePath() {
        return databasePath;
    }

    @Override
    public String toString() {
        return "Ipv4CitySingleProperties{" +
                "databasePath='" + databasePath + '\'' +
                ", refresh=" + refresh +
                '}';
    }

    public RefreshProperties getRefresh() {
        return refresh;
    }

    public void setRefresh(RefreshProperties refresh) {
        this.refresh = refresh;
    }

    public void setDatabasePath(String databasePath) {
        this.databasePath = databasePath;
    }

}

class RefreshProperties {

    /**
     * 是否刷新数据库
     */
    private Boolean enabled = false;

    private Long time = 21600000L;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RefreshProperties{" +
                "enabled=" + enabled +
                ", time=" + time +
                '}';
    }
}
