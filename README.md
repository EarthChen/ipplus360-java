# ipplus360 离线 ip 数据库 sdk

[![](https://jitpack.io/v/EarthChen/ipplus360-java.svg)](https://jitpack.io/#EarthChen/ipplus360-java)

>暂时只提供 ipv4城市库(没有其他数据库可供测试)


## ipplus360-awdb-java


### ipv4-city-single

1. 引入依赖

```groovy
implementation("io.github.earthchen:ipplus360-awdb-java:${latest}")
```

同时支持 jetpack
```groovy
implementation("com.github.earthchen:ipplus360-awdb-java:${latest}")
```

2. 使用

```java
Ipv4CitySingleService ipv4CitySingleService = new Ipv4CitySingleService(new File("IP_city_single_WGS84.awdb"))
Ipv4City ipv4City = ipv4CitySingleService.getCity("111.111.111.111");
```

## ipplus360-awdb-spring-boot-starter

该模块为 spring-boot 的 starter，提供功能如下

- 根据 ip 查询城市信息
- 定时刷新 database 功能

1. 引入依赖

```groovy
implementation("io.github.earthchen:ipplus360-awdb-spring-boot-starter:${latest}")
```

同时支持 jetpack
```groovy
implementation("com.github.earthchen:ipplus360-awdb-spring-boot-starter:${latest}")
```

2. 使用

在 spring-boot 的配置文件中配置参数
```yaml
ipplus360:
  ipv4-city-single:
    database-path: /Users/earthchen/work/rz/ip/ipplus360-awdb-java/IP_city_single_WGS84.awdb
    refresh:
      # 是否开启定时刷新
      enabled: false
      # 刷新频率 ms
      time: 5000
```





