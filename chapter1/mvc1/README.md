# Springboot 模拟
## 模拟springboot启动项目
1.在项目根目录新建src/main/webapp目录<br/>
2.基于servlet3.0,SPI特性，从spring-webjar包中将META_INF/services目录及文件整个拷贝至target/class目录。<br/>
3.启动Test main函数。