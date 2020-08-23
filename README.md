# API service logging Spring Boot Starter
Automatically configures logging of API requests and responses (headers and payloads).<br/>
**Example**,
````html
2020-08-23 18:35:01.979  INFO 1 --- [nio-8080-exec-1] o.s.s.b.a.l.c.PropertiesLoggingConfig    : [RQ:1][GET]http://localhost:8080/api/fields
||||HEADERS:{host=localhost:8080, connection=Keep-Alive, cache-control=no-cache, accept-encoding=gzip,deflate, accept=*/*, user-agent=Apache-HttpClient/4.5.10 (Java/11.0.6)}||||
2020-08-23 18:35:02.571  INFO 1 --- [nio-8080-exec-1] o.s.s.b.a.l.c.PropertiesLoggingConfig    : [RS:1][GET][200]http://localhost:8080/api/fields in 592 ms
||||HEADERS:{}||||
||||BODY:{"error":null,"fields":[{"id":"05ecd0ca-b290-43ca-aa53-ed8ac97d6bc7","label":"Email","type":"SINGLE_LINE_TEXT","required":true,"active":true},{"id":"a158b5e1-0b58-43a1-a0ef-4a84f2c370a4","label":"Sex","type":"RADIO_BUTTON","required":false,"active":true},{"id":"b3c4911e-ac92-4c58-aa41-fc519f6a9cca","label":"Full Name","type":"SINGLE_LINE_TEXT","required":true,"active":true}]}||||

````

## Getting started

Create if not exists or modify `${HOME}/.m2/setting.xml` file:<br/>
````xml
  ...
  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>

  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
          <releases><enabled>true</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </repository>
        <repository>
          <id>github</id>
          <name>GitHub asventetsky Apache Maven Packages</name>
          <url>https://maven.pkg.github.com/asventetsky/api-service-logging-spring-boot-starter</url>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>asventetsky</username>
      <password>1fdde090dfc47cc99c05a9f5e61c66b020a297d0</password>
    </server>
  </servers>
  ...
````
Add to `pom.xml`:<br/>
````xml
<dependency>
    <groupId>org.sventetsky.springframework.boot</groupId>
    <artifactId>api-service-logging-spring-boot-starter</artifactId>
    <version>0.2.2</version>
</dependency>
````



## Configuration
Additionally you can configure logging of headers and payloads by modifying `application.properties` (or `application.yaml`):
````properties
api-service-logging.logging-enabled=false
api-service-logging.log-headers=false
api-service-logging.log-payload=false
```` 
By default, all properties are `true`.