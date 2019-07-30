### 多态

- 多种表现形态(建立在继承或实现的基础上)

- 静态多态：方法的重载
- 动态多态：在运行或使用过程中进行对象的类型转换  

```java
class Dog extends  Animal{    
    
}
public class Animal{
    public static void main(String[] args){
      Dog dog = new Dog();// Dog  is  a  dog;
      // 
      Animal dog = new Dog(); // 类型转换 Animal is a dog;
      // 向上转型：自动转换，转型后子类特有的属性和方法暂时都丢失了，无法访问
      // 但是子类重写后的方法还在，执行也是重写后的方法
    }
}
```

### 内部类

内部类：在类中使用的类
```java
public class InnerClass {
    
    String str;
    // 成员内部类
    public class Test{
        public void show(){
            System.out.println(str);
        }
    }
    // 静态内部类
    static class TestStatic{
        static {
            System.out.println("只执行一次");
        }
        public TestStatic(){
        }
    }
}
```
调用内部类：
```java
public class TestInnerClass{
    public static void main(String[] args){
      InnerClass innerClass = new InnerClass();
      // 把内部类看成是类下面的成员信息
      InnerClass.Test t1 = new InnerClass().Test();
      
       InnerClass innerClass1 =new InnerClass();
       InnerClass.Test t1 = innerClass.new Test();

       InnerClass.TestStatic t1 = new InnerClass.TestStatic();
    }
}
```
在Java源文件中只有一个public的类  
方法中不能添加方法
