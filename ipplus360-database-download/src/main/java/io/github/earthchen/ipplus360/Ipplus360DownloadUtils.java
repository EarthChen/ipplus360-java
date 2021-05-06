package io.github.earthchen.ipplus360;

/**
 * @author earthchen
 * @date 2021/5/6
 **/
public class Ipplus360DownloadUtils {

    public static final String databaseDownloadUrl = "https://mall.ipplus360" +
            ".com/download/file?downloadId=%s&fileName=%s";

    public static final String databaseMd5Url = "https://mall.ipplus360" +
            ".com/download/fileMd5?downloadId=%s&fileName=%s";

    public static String getDownloadUrl(String downloadId, String filename) {
        return String.format(databaseDownloadUrl, downloadId, filename);
    }

    public static String getDownloadMd5(String downloadId, String filename) {
        return String.format(databaseMd5Url, downloadId, filename);
    }
}
