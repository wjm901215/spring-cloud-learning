# spring-gateway入门
##yml配置详解
```
spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
```
* spring.cloud.gateway.discovery.locator.enabled：是否与服务注册于发现组件进行结合，通过 serviceId 转发到具体的服务实例。默认为 false，设为 true 便开启通过服务中心的自动根据 serviceId 创建路由的功能。
* eureka.client.service-url.defaultZone指定注册中心的地址，以便使用服务发现功能

### Gateway负载测试
1、启动 EurekaServerApplication服务注册中心
2、启动 HelloApplication服务提供
3、启动 GatewayEurekaApplication 服务网关
```
http://网关地址：端口/服务中心注册 serviceId/具体的url

```
比如我们的 eureka-producer 项目有一个 /hello/SpiderMan 的服务，访问此服务的时候会返回：hello SpiderMan。

比如访问地址：[http://localhost:8001/hello/SpiderMan](http://localhost:8001/hello/SpiderMan)，页面返回：hello SpiderMan!

按照上面的语法我们通过网关来访问，浏览器输入：[http://localhost:8888/HELLO-SERVICE/hello/SpiderMan](http://localhost:8888/HELLO-SERVICE/hello/SpiderMan) 同样返回：hello SpiderMan!证明服务网关转发成功。

再启动一个eureka-producer，然后访问gateway地址[http://localhost:8888/HELLO-SERVICE/hello/SpiderMan](http://localhost:8888/HELLO-SERVICE/hello/SpiderMan) ，就可以达到负载效果。

### 基于 Filter(过滤器) 实现的高级功能
Spring Cloud Gateway 的 Filter 的生命周期不像 Zuul 的那么丰富，它只有两个：“pre” 和 “post”。

PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
Spring Cloud Gateway 的 Filter 分为两种：GatewayFilter 与 GlobalFilter。GlobalFilter 会应用到所有的路由上，而 GatewayFilter 将应用到单个路由或者一个分组的路由上。

Spring Cloud Gateway 内置了9种 GlobalFilter，比如 Netty Routing Filter、LoadBalancerClient Filter、Websocket Routing Filter 等，根据名字即可猜测出这些 Filter 的作者，具体大家可以参考官网内容：[Global Filters](https://cloud.spring.io/spring-cloud-gateway/reference/html/)

利用 GatewayFilter 可以修改请求的 Http 的请求或者响应，或者根据请求或者响应做一些特殊的限制。
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_parameter_route
        uri: http://example.org
        filters:
        - AddRequestParameter=foo, bar
```
这样就会给匹配的每个请求添加上foo=bar的参数和值。

浏览器访问：http://localhost:8001/foo服务提供者地址，页面返回：hello null!

浏览器访问：http://localhost:8888/foo网关地址，页面返回：hello bar!，说明成功接收到参数 foo 参数的值 bar ,证明网关在转发的过程中已经通过 filter 添加了设置的参数和值。