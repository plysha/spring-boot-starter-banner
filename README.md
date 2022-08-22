# Spring-boot-starter-banner
Spring boot starter that allows to change banner logo.

You need this dependency:

```xml
<dependency>
    <groupId>ru.plysha.banner</groupId>
    <artifactId>spring-boot-starter-banner</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
Also you need to configure the maven repository to download the artifact:

```xml
<distributionManagement>
    <repository>
        <id>repsy</id>
        <name>repository</name>
        <url>https://repo.repsy.io/mvn/plyshaa/banner</url>
    </repository>
</distributionManagement>
```

Usage:

You can customize your banner logo by changing name property
in your `application.yml`(.property).

```yml
spring:
  banner:
    name: your banner name
```
