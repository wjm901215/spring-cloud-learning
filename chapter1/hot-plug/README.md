# 热插拔测试
- `javax.servlet.ServletContainerInitializer这个接口会在web应用启动阶段被通知，以进行任何必要的servlet，filter，listener注册。`

- `通过servlet3.0，SpiderInitializer实现ServletContainerInitializer接口，在mvc1项目中引入hot-plug`

- `在mvc1项目中在META-INF/service/javax.servlet.ServletContainerInitializer文件中将SpiderInitializer.class加入
然后启动mvc1项目，就可以执行SpiderInitializer`
