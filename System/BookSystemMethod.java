package cn.homework;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author Tesla
 * @ClassName BookSystemMethod
 * @Description //TODO
 * @Date 2019/7/25 10:19
 */
public class BookSystemMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (login(input)){
            menuControl(input);
        }
    }
    public static boolean login(Scanner input){
        boolean result;
        int times = 1;
        do {
            System.out.println("请输入用户名：");
            String userName = input.next();
            System.out.println("请输入密  码：");
            String passWord= input.next();
            result = loginValidate(userName,passWord);
            // 结果判断
            if ( result){
                System.out.println("登录成功！");
                return true;
            }else {
                times++;
                if (times<4){
                    System.out.println("登录失败！继续输入：");
                }else {
                    System.out.println("次数用完、程序终止！");
                }
            }
        } while (!result&&times<=3);
        return false;
    }
    public static boolean loginValidate(String userName,String passWord){
        // 设置用户数据
        String[][] users = {{"zhangsan","123"},{"lily","123"},{"wanger","111"},{"mary","123"}};
        boolean result = false;
        for (int i = 0;i<users.length;i++){
            if (userName.equals(users[i][0])&&passWord.equals(users[i][1])){
                result = true;
            }
        }
        return result;
    }
    public static void menu(){
        System.out.println("<<-欢迎来到国信安java203图书管理系统->>");
        System.out.println("1、显示图书列表");
        System.out.println("2、添加图书");
        System.out.println("3、删除图书");
        System.out.println("4、退出系统");
        System.out.println("<<---------------------------------->>");
        System.out.println("请输入您的选择：");
    }
    public static void menuControl(Scanner input) {
        // 数据
        // 设置图书数据
        String[][] books = {
                {"a", "阿拉伯"},
                {"c", "测试原理"},
                {"d", "嘟嘟嘟"},
                {"e", "鹅鹅鹅"},
                {"b", "波波维奇"}
        };
        // 添加后的数据存储
        String[][] newBooks = new String[books.length + 1][2];

        boolean result=false;
        do {
            menu();
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    // 排序处理
                    order(books);
                    result=isContinue(input);
                    break;
                case 2:
                    // 添加处理
                    books = addBook(input,books,newBooks);
                    result=isContinue(input);
                    break;
                case 3:
                    // 删除处理
                    books = deleteBook(input,books);
                    result=isContinue(input);
                    break;
                case 4:
                    // 退出系统
                    System.out.println("成功退出系统、谢谢！");
                    result = false;
                    break;
                default:
                    System.out.println("输入错误！请重新输入！");
                    break;
            }
        }while (result);
    }

    public static boolean isContinue(Scanner input){
        System.out.println("输入y/n(y退出系统，n不退出系统)");
        String yOrN = input.next();
        if (yOrN.equals("y")){
            System.out.println("成功退出系统！");
            return false;
        }
        return true;
    }

    public static void showBook(String[][]  books){
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i][1]);
        }
    }

    public static void  order(String[][]  books){
        // 选择排序
        for (int i = 0;i<books.length-1;i++){
            for (int j =i+1;j<books.length;j++){

                // 得到首字母，并转换成小写字母
                char char1 = books[i][0].charAt(0);
                if (char1<97){
                    char1 = (char)(char1+32);
                }
                char char2 = books[j][0].charAt(0);
                if (char2<97){
                    char2 = (char)(char2+32);
                }
                if (char1>char2){
                    String temp[];
                    temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        // 排序结果输出
        showBook(books);
    }

    public  static String[][]  addBook(Scanner input,String[][]  books,String[][] newBooks){
        int index = 0;
        boolean result1 = true;
        String newFirst ="";
        String newBook="";
        // 输入添加信息
        while (index<books.length&&result1){
            System.out.println("请输入你要添加的图书的首字母：");
            newFirst = input.next();
            System.out.println("请输入你要添加的图书：");
            newBook = input.next();

            // 判断是否重复
            if (newBook.equals(books[index][1])){
                System.out.println("输入重复，请重新输入！");
                result1 = true;
            }else {
                result1 = false;
            }
            index++;
        }
        // 赋值添加数据
        if (result1==false){
            newBooks[newBooks.length-1][0] = newFirst;
            newBooks[newBooks.length-1][1] = newBook;
        }
        // 添加原数组数据
        for (int i = 0;i<newBooks.length-1;i++){
            newBooks[i] = books[i];
        }
        // 更新原数组
        books = newBooks;
        System.out.println("添加成功！");
        order(books);
        return books;
    }

    public static String[][] deleteBook(Scanner input,String[][] books) {
        // 删除后的数据存储
        String[][] deleteBook = new String[books.length - 1][2];
        System.out.println("--------------------");
        showBook(books);
        // 检查原数组是否有要删除的书籍
        boolean flag = true;
        int bookId = 0;
        System.out.println("输入你要删除的书名：");
        String aim = input.next();
        for (int j = 0; j < books.length; j++) {
            if (books[j][1].equals(aim)) {
                bookId = j;
                flag = false;
            }
        }
        // 做出判断 并处理判断结果
        if (flag) {
            System.out.println("没有你要删除的书籍！");
        } else {
            if (bookId==0){
                for (int i= 0;i<deleteBook.length;i++){
                    deleteBook[i] = books[i+1];
                }
            }else if(bookId==books.length-1){
                System.out.println(deleteBook.length);
                for (int i = 0;i<deleteBook.length;i++ ){
                    deleteBook[i] = books[i];
                    System.out.println(books[i]);
                }
            }else {
                for (int x = 0; x < bookId; x++) {
                    deleteBook[x] = books[x];
                }
                for (int y = bookId; y < books.length - 1; y++) {
                    deleteBook[y] = books[y + 1];
                }
            }
            System.out.println("删除成功！");
            // 更新原数组
            books = deleteBook;
            showBook(books);
        }
        return books;
    }
}
