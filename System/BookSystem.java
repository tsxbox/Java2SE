package cn.homework;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author Tesla
 * @ClassName BookSystem
 * @Description //TODO
 * @Date 2019/7/23 15:14
 */
public class BookSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 设置用户数据
        String[]  userName = {"zhangsan","lily"};
        String[]  passWord = {"123456","123"};
        // 设置图书数据
        String[][]  book= {
            {"a","阿莫西林"},
                {"c","测试原理"},
                {"d","斗士传奇"},
                {"e","鹅鹅鹅"},
                {"b","波波维奇的故事"}
        };
        // 添加后的数据存储
        String[][] books = new String[book.length+1][2];
        // 删除后的数据存储
        String[][] deleteBook = new String[books.length-1][2];

        // 登录状态的判断值
        boolean result = true;
        // 登录次数
        int times = 0;

        // 判断登录成功与否
        while (times<=2&&result) {
            System.out.println("请输入用户名：");
            String user = input.next();
            System.out.println("请输入密  码：");
            String word = input.next();
            int i = 0;
            while (i < userName.length&&result) {
                if (userName[i].equals(user) && passWord[i].equals(word)) {
                    System.out.println("登录成功：");
                    result = false;
                } else {
                    i++;
                }
            }
            times++;
            if(result==true) {
                System.out.println("登录失败,请重新输入！");
            }
        }

        // 提示用户次数用完
        if (times==3){
            System.out.println("次数已用完。程序终止！");
            System.out.println("--------------------");
        }

        // 进入主页面
        int choice1 = 1;
        while (result==false&&choice1==1) {
            if (choice1==1) {
                System.out.println("<<欢迎来到国信安java203图书管理系统>>");
                System.out.println("1、显示图书列表");
                System.out.println("2、添加图书");
                System.out.println("3、删除图书");
                System.out.println("4、退出系统");
                System.out.println("<<-------------------------------->>");
                System.out.println("请输入您的选择：");
                int choice = input.nextInt();
                switch (choice) {

                    // 功能1
                    case 1:
                        // 排序
                        for (int i = 0; i < book.length - 1; i++) {
                            for (int j = i + 1; j < book.length; j++) {
                                char ch = book[i][0].charAt(0);
                                char ch1 = book[j][0].charAt(0);
                                if (ch > ch1) {
                                    String temp[];
                                    temp = book[i];
                                    book[i] = book[j];
                                    book[j] = temp;
                                }
                            }
                        }

                        // 排序结果输出
                        for (int i = 0; i < book.length; i++) {
                            System.out.println(book[i][1]);
                        }
                        // 提示信息及返回上一层
                        System.out.println("1、返回上一层");
                        System.out.println("其余任意键退出系统");
                        System.out.println("请输入您的选择：");
                        choice1 = input.nextInt();
                        if (choice1 == 1) {
                            break;
                        }
                        System.out.println("退出系统成功，谢谢使用！");
                        break;

                        //  功能2
                    case 2:
                        int level = 0;
                        boolean result1 = true;
                        String newFirst ="";
                        String newBook="";

                        // 输入添加信息
                        while (level<book.length&&result1){
                            System.out.println("请输入你要添加的图书的首字母：");
                            newFirst = input.next();
                            System.out.println("请输入你要添加的图书：");
                            newBook = input.next();

                            // 判断是否重复
                            if (newBook.equals(book[level][1])){
                                System.out.println("输入重复，请重新输入！");
                                result1 = true;
                            }else {
                                result1 = false;
                            }
                            level++;
                        }
                        // 赋值添加数据
                        if (result1==false){
                            books[book.length][0] = newFirst;
                            books[book.length][1] = newBook;
                        }
                        // 添加原数组数据
                        for (int i = 0;i<book.length;i++){
                            books[i] = book[i];
                        }

                        // 排序
                        for(int i = 0;i<=book.length;i++){
                            for (int j = i+1;j<book.length+1;j++){
                                char ch3 = books[i][0].charAt(0);
                                char ch4 = books[j][0].charAt(0);
                                if (ch3 > ch4) {
                                        String temp1[];
                                        temp1 = books[i];
                                        books[i] = books[j];
                                        books[j] = temp1;
                                }
                            }
                        }
                        System.out.println("添加成功！");
                        // 更新原数组
                        book=books;
                        for (int i = 0; i < books.length; i++) {
                            System.out.println(books[i][1]);
                        }
                        // 提示信息及返回上一层
                        System.out.println("1、返回上一层");
                        System.out.println("其余任意键退出系统");
                        System.out.println("请输入您的选择：");
                        choice1 = input.nextInt();
                        if (choice1 == 1) {
                            break;
                        }
                        System.out.println("退出系统成功，谢谢使用！");
                        break;

                     // 功能3
                    case 3:
                        System.out.println("--------------------");
                        for (int i = 0; i < books.length; i++) {
                            System.out.println(books[i][1]);
                        }
                        // 检查原数组是否有要删除的书籍
                        int flag=0;
                        System.out.println("输入你要删除的书名：");
                        String  aim = input.next();
                        for (int j = 0;j<books.length;j++){
                            if(books[j][1].equals(aim)){
                                flag = j;
                            }
                        }
                        // 做出判断 并处理判断结果
                        if (flag==0){
                            System.out.println("没有你要删除的书籍！");
                        }else {
                            for (int x = 0;x<flag;x++){
                                deleteBook[x] = books[x];
                            }
                            for (int y = flag;y<deleteBook.length;y++){
                                deleteBook[y] = books[y+1];
                            }
                        }

                        System.out.println("删除成功！");
                        // 更新原数组
                        book = deleteBook;
                        for (int m = 0;m<deleteBook.length;m++){
                            System.out.println(deleteBook[m][1]);
                        }

                        // 操作完成后提示信息
                        System.out.println("1、返回上一层");
                        System.out.println("其余任意键退出系统");
                        System.out.println("请输入您的选择：");
                        choice1 = input.nextInt();
                        if (choice1 == 1) {
                            break;
                        }
                        System.out.println("退出系统成功，谢谢使用！");
                        break;
                    case 4:
                        if (choice==4){
                            choice1 = 4;
                        }
                        System.out.println("退出系统成功，谢谢使用！");
                        break;
                    default:
                        System.out.println("输入错误！请重新输入！");
                }
            }
        }
    }
}
