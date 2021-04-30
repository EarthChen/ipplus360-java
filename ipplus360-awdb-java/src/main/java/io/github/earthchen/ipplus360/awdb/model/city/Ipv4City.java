package  io.github.earthchen.ipplus360.awdb.model.city;

/**
 * @author earthchen
 * @date 2021/4/30
 **/
public class Ipv4City {

    /**
     * 大洲，包含七大洲和保留IP
     */
    private String continent;

    /**
     * IP所属机构名称
     */
    private String owner;

    /**
     * 国家
     */
    private String country;

    /**
     * 行政区划代码
     */
    private String adcode;

    /**
     * 城市
     */
    private String city;

    /**
     * 时区
     * <p>
     * eg: UTC+8
     */
    private String timezone;

    /**
     * 运营商名称
     */
    private String isp;

    /**
     * 定位精度
     */
    private String accuracy;

    /**
     * 定位方式
     */
    private String source;

    /**
     * 自治域编码
     */
    private String asnumber;

    /**
     * 国家编码
     */
    private String areacode;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * WGS84坐标系经度
     */
    private String lngwgs;

    /**
     * 省份
     */
    private String province;

    /**
     * WGS84坐标系纬度
     */
    private String latwgs;

    /**
     * 定位半径
     */
    private String radius;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAsnumber() {
        return asnumber;
    }

    public void setAsnumber(String asnumber) {
        this.asnumber = asnumber;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLngwgs() {
        return lngwgs;
    }

    public void setLngwgs(String lngwgs) {
        this.lngwgs = lngwgs;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLatwgs() {
        return latwgs;
    }

    public void setLatwgs(String latwgs) {
        this.latwgs = latwgs;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Ipv4City{" +
                "continent='" + continent + '\'' +
                ", owner='" + owner + '\'' +
                ", country='" + country + '\'' +
                ", adcode='" + adcode + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", isp='" + isp + '\'' +
                ", accuracy='" + accuracy + '\'' +
                ", source='" + source + '\'' +
                ", asnumber='" + asnumber + '\'' +
                ", areacode='" + areacode + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", lngwgs='" + lngwgs + '\'' +
                ", province='" + province + '\'' +
                ", latwgs='" + latwgs + '\'' +
                ", radius='" + radius + '\'' +
                '}';
    }
}
