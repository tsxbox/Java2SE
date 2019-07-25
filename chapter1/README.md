## Java2SE

### jdk

- JDK:Java Development Kitten (java开发工具包)
- JRE:Java Runtime Environment(Java运行时环境)
- JVM:Java Virtual Machine(java虚拟机),解释器的作用(跨平台)

- 开闭原则：对于扩展是开放的，对于修改是关闭。

### jdk的安装

##### 按提示进行安装

##### 环境变量的配置
- CLASSPATH: .;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
- JAVA_HOME: C:\Program Files\Java\jdk1.8.0_211
- PATH:%JAVA_HOME%\jre\bin  %JAVA_HOME%\bin\

##### 测试安装结果
- 命令：java、javac、java -version



### 进制的转换
- Java通过编译.java生成.class文件
-  二进制：0 1
- 十进制：0 1 2 3 4 5 6 7 8 9
-  十进制转二进制：除二取余  小数取整 ，乘2取整
-  178
-  10110010
-  二进制转十进制：从右边开始乘以权重值，根据顺序，从0次方开始
-  八进制: 0 1 2 3 4 5 6 7
- 除八取余
-  十六进制：0 1 2 3 4 5 6 7 8 9 A B C D E F
