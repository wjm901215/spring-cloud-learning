# spring-gateway入门
##yml配置详解
```
spring:
  cloud:
    gateway:
      routes:
        - id: neo_route
          uri: https://github.com/
          predicates:
            - Path=/wjm901215
```
* id：我们自定义的路由 ID，保持唯一
* uri：目标服务地址
* predicates：路由条件，Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）:
    > 通过时间匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
           - id: time_route
            uri: https://github.com/
            predicates:
             - After=2018-01-20T06:06:06+08:00[Asia/Shanghai]
             - Before=2018-01-20T06:06:06+08:00[Asia/Shanghai]
             - Between=2018-01-20T06:06:06+08:00[Asia/Shanghai], 2019-01-20T06:06:06+08:00[Asia/Shanghai]
    ```
    > 通过cookie匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
           - id: cookie_route
             uri: https://github.com/
             predicates:
             - Cookie=ityouknow, kee.e
    ```
    > 通过Header匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: header_route
            uri: https://github.com/
            predicates:
            - Header=X-Request-Id, \d+
    ```
    > 通过 Host 匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: host_route
            uri: https://github.com/
            predicates:
            - Host=**.ityouknow.com
    ```    
    > 通过请求方式匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: method_route
            uri: https://github.com/
            predicates:
            - Method=GET
    ```    
    > 通过请求路径匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: host_route
            uri: https://github.com/
            predicates:
            - Path=/foo/{segment}
    ```    
    > 通过请求参数匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: query_route
            uri: https://github.com/
            predicates:
            - Query=smile
    ```    
    > 通过请求 ip 地址进行匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: query_route
            uri: https://github.com/
            predicates:
            - Query=keep, pu.
    ```    
    > 组合使用
* filters：过滤规则，本示例暂时没用
