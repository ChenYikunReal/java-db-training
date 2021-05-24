# MyBatis学习笔记

![](../../images/mybatis.png)

1. 报错 `### Error querying database. Cause: java.lang.IllegalArgumentException: Mapped Statements collection...`
<br>在配置mybatis-config.xml文件时，没有对应的配置，这个配置可能是没有添加mapper.xml配置文件的路径，也可能是没有这个方法。
2. 报Warning如下：
    ```text
    Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
    ```
    解决方法是在数据库连接后加上`?useSSL=false`
