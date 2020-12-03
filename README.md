# 简介
该项目是一个简单的教务查询系统，用于熟悉基本的SSM整合开发。

该项目从 https://github.com/JaceyRx/Examination_System 拷贝而来。使用原项目的前端页面，重新完成了后端请求，并使用了ajax技术。

# 项目搭建详细博客
项目整体配置：https://blog.csdn.net/jumpe_17/article/details/110404104

shiro：https://blog.csdn.net/jumpe_17/article/details/110564034

# 使用技术
IOC容器：Spring

Web框架：SpringMVC

ORM框架：Mybatis

安全框架：Shiro

数据源：C3P0

日志：log4j

前端框架：Bootstrap

# 快速上手
### 1、运行环境和所需工具
* 编译器：IntelliJ IDEA
* 项目构建工具：Maven
* 数据库：Mysql
* JDK版本：jdk1.8
* Tomcat版本：Tomcat8.x
### 2、初始化项目
* 在你的Mysql中，创建一个数据库名称为 acade 的数据库，并导入我提供的 .sql 文件,
* 进入src/main/resources修改mysql.properties配置文件,把数据库登录名和密码，改为你本地的
* 使用 IntelliJ IDEA 导入项目，选择Maven项目选项，一路点击next就行，导入项目后，如果src目录等，都没显示出来，别急先使用Maven构建该项目
* 在 IntelliJ IDEA 中，配置我们的 Tomcat， 然后把使用Maven构建好的项目添加到Tomcat中
* 运行
* 登录账户
  * 管理员账户：admin
  * 老师账户：1001
  * 学生账户：10001
  * 密码均为：123
# 页面展示
登录页

![image](https://gitee.com/jumper17/Academic_System/raw/main/image/login.png)

主页

![image](https://gitee.com/jumper17/Academic_System/raw/main/image/main.png)

添加课程

![image](https://gitee.com/jumper17/Academic_System/raw/main/image/add.png)

修改密码

![image](https://gitee.com/jumper17/Academic_System/raw/main/image/alter.png)