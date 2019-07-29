## Java2SE

### java语言版本迭代概述

　1995 jdk 1.0 SUN--->Oracle  
　jdk 1.5 = jdk 5.0  
　j2SE-->javaSE    
　j2EE-->javaEE   
　j2Me-->javaME  
  java 语言的三个版本：javaSE / javaEE / javaME 
  
### java语言特性

  1、面向对象性：两个重要的概念：类与对象；三大特征：封装、继承、多态    
2、健壮性：1.去除了c/c++的指针 2.提供了垃圾自动回收机制。--->仍然可能出现内存溢出、内存泄漏  
  3、跨平台性：write once,run anywhere。 “一次编译，到处运行”  -->JVM的支持  
  4、编译和解释性：Java编译程序生成字节码（byte-code），而不是通常的机器码。在一个解释性的环境中，程序开发的标准“链接”阶段大大消失了。如果说Java还有一个链接阶段，它只是把新类装进环境的过程，它是增量式的、轻量级的过程。因此，Java支持快速原型和容易试验，它将导致快速程序开发。这是一个与传统的、耗时的“编译、链接和测试”形成鲜明对比的精巧的开发过程。  
  5、安全性：Java的存储分配模型是它防御恶意代码的主要方法之一。Java没有指针，所以程序员不能得到隐蔽起来的内幕和伪造指针去指向存储器。更重要的是，Java编译程序不处理存储安排决策，所以程序员不能通过查看声明去猜测类的实际存储安排。编译的Java代码中的存储引用在运行时由Java解释程序决定实际存储地址。
### jdk

- JDK:Java Development Kitten (java开发工具包)
- JRE:Java Runtime Environment(Java运行时环境)
- JVM:Java Virtual Machine(java虚拟机),解释器的作用(跨平台)

- 开闭原则：对于扩展是开放的，对于修改是关闭。

  **jdk是给开发人员使用的，jre和jvm是给普通用户使用**

### jdk的安装

##### 按提示进行安装(默认即可)
![图片alt](jdkdir.png)

  1、bin：该路径下存放了JDK的各种工具命令，常用的javac、java等命令就放在该路径下。  
  2、db：该路径是安装Java DB的路径。    
  3、include：一些平台特定的头文件。  
  4、jre：该路径下安装的就是运行Java程序所必须的JRE环境。   
  5、lib:该路径下存放的是JDK工具命令的实际执行程序。（即bin中绝大部分命令运行的是lib中程序）   
  6、javafx-src.zip：该压缩文件里存放的就是Java FX所有核心类库的源代码，本书不会涉及Java FX的相关内容。  
  7、src.zip：该压缩文件里存放的是Java所有核心类库的源代码。   
  8、README和LICENSE等说明性文档。


##### 环境变量的配置
- CLASSPATH: **.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar**
- JAVA_HOME: **C:\Program Files\Java\jdk1.8.0_211**
- PATH: **%JAVA_HOME%\jre\bin**   **%JAVA_HOME%\bin**

##### 测试安装结果

###### 常用dos命令介绍：
```java
/**
 *@desc: dos命令
 *@Description:
 * dir:列出当前文件目录下的所有文件;
 * md:创建一个新目录;
 * rd:删除一个目录;
 * cd:进入指定的目录;
 * cd..:退回到上一级目录;
 * cd\:退回到根目录;
 * del:删除文件;
 * exit:退出;
 * 常用快捷键
 * ←   →：移动光标
 * ↑   ↓：调阅历史操作命令
 * Delete和Backspace：删除字符
 **/
```
- 命令：java、javac、java -version
**Windows+R键进入cmd**
- 通过盘符**d:、c:、 cd 、dir**进入Java源文件相关目录
- javac HelloWorld.java 编译.java文件，生成.class的字节码文件
- java  HelloWorld      运行字节码文件

### 进制的转换
- Java通过编译.java生成.class文件  
  二进制：0 1  
  十进制：0 1 2 3 4 5 6 7 8 9  
  十进制转二进制：除二取余  小数取整 ，乘2取整
   178-10110010  
  二进制转十进制：从右边开始乘以权重值，根据顺序，从0次方开始  
  八进制: 0 1 2 3 4 5 6 7  
  除八取余  
  十六进制：0 1 2 3 4 5 6 7 8 9 A B C D E F

### 入门程序
```java
package cn.study;
/**
 * 入门程序：HelloWorld
 * @author 汤实鑫
 *
 */
public class HelloWorld {
	/**
	 * Java程序入口
	 * @param args 运行main方法的时候传进来的数据
	 */
	public static void main(String[] args) {
		System.out.println("hello world!");
	}
}
```