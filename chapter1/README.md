# 注册中心多实例服务启动
## eureka-server 服务注册中心启动
 启动两个注册中心实例，服务和服务直接互相注册以及同步，保证服务的高可用。
 1. 在host中配置配置peer1、peer2<br/>
    127.0.0.1 peer1<br/>
    127.0.0.1 peer2
 2. 启动eureka服务注册中心，分别设置peer1和peer2实例进行启动<br>
    - 在idea中，配置vm options：-Dspring.profiles.active=peer2<br/>
    ![配置](https://github.com/wjm901215/spring-cloud-learning/blob/master/images/eureka-server-config.png)<br/>
 3.依次启动peer1服务和peer2服务   
 4.访问：http://localhost:1111/，http://localhost:1112/
##eureka-provider 启动服务提供者