package io.github.earthchen.ipplus360;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class DownloadCliArgs {

    private String downloadId;

    private String filename;

    private String databaseType = "awdb";

    private String downloadPath;

    private String targetFilenamePath;

    private Long fixedDelay = -1L;

    @Override
    public String toString() {
        return "DownloadCliArgs{" +
                "downloadId='" + downloadId + '\'' +
                ", filename='" + filename + '\'' +
                ", databaseType='" + databaseType + '\'' +
                ", downloadPath='" + downloadPath + '\'' +
                ", targetFilenamePath='" + targetFilenamePath + '\'' +
                ", fixedDelay=" + fixedDelay +
                '}';
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public Long getFixedDelay() {
        return fixedDelay;
    }

    public void setFixedDelay(Long fixedDelay) {
        this.fixedDelay = fixedDelay;
    }

    public String getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(String downloadId) {
        this.downloadId = downloadId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getTargetFilenamePath() {
        return targetFilenamePath;
    }

    public void setTargetFilenamePath(String targetFilenamePath) {
        this.targetFilenamePath = targetFilenamePath;
    }

}
