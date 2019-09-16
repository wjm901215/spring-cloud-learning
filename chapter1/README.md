# 注册中心多实例服务启动
## eureka-server 服务注册中心启动
    启动两个注册中心实例，服务和服务直接互相注册以及同步，保证服务的高可用。
 1. 在host中配置配置peer1、peer2 <br/>
    127.0.0.1 peer1 <br/>
    127.0.0.1 peer2
 2. 启动eureka服务注册中心，分别设置peer1和peer2实例进行启动<br>
    - 在idea中，配置vm options：-Dspring.profiles.active=peer2 <br/>
    ![配置](https://github.com/wjm901215/spring-cloud-learning/blob/master/images/eureka-server-config.png) <br/>
    - 依次启动peer1服务和peer2服务   
    - 访问：http://localhost:1111/，http://localhost:1112/
##eureka-provider 启动服务提供者
    服务提供者启动多个服务
 1. 启动eureka-provider服务，方法提供,启动两个服务，保证服务的高可用<br>
    - 在idea中，配置vm options：-Dserver.port=8001 <br/>
     - 在idea中，配置vm options：-Dserver.port=8002 <br/>
    ![配置](https://github.com/wjm901215/spring-cloud-learning/blob/master/images/eureka-provider8001.png) <br/>
  
 2. 页面访问：http://localhost:8001/hello 和 http://localhost:8002/hello <br/>
    页面显示Hello Word
##ribbon-consumer 实现负载功能
    启动ribbon-consumer服务
 1. 访问：http://localhost:9000/ribbon-consumer，页面显示Hello Word
 2. 刷新页面，观察eureka-provider两个后台日志