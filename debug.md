# 调试环境准备

## Smartbi
- 配置远程调试

修改 `C:\Smartbi\Tomcat\bin\startup.cmd`文件，在`set JAVA_OPTS=-Xms128m`后加入参数
```
-Xmx2047m -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888
```
- 获取类文件
```
依赖库
C:\Smartbi\Tomcat\webapps\smartbi\WEB-INF\lib

补丁工具包
C:\Smartbi\Tomcat\bin\exts-smartbi\smartbiExtension2007268578646187422.tmp\META-INF\classes\smartbi\security\patch
```

## Ecology
- 配置远程调试

修改`%WEAVER_HOME%\Resin\conf\resin.properties`文件，在`jvm_args`参数后加入调试参数
![](https://image-oss-cfl.oss-cn-beijing.aliyuncs.com/images/image-20230818182918976.png)
- 获取类文件
```
/usr/weaver/ecology/WEB-INF/lib
/usr/weaver/Resin4/lib
/usr/weaver/ecology/classbean
```

## Seeyon