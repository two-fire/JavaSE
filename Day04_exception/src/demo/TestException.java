package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * @Author : LiuYan
 * @create 2021/2/2 21:58
 * 异常：
 *  程序运行过程中出现的不正常情况
 *  注意：
 *      1. 相同代码在运行的时候，根据输入参数或者操作不同，可能会也可能不会发生异常，
 *      应该在写代码过程中尽量保证代码的正确性，不要到处是bug。
 *      2. 如果要解决代码中的异常，需要添加非常复杂的代码逻辑判断，代码会臃肿且要花大精力处理bug还不一定能解决。
 *      因此推荐使用异常机制来处理。
 *      3. 程序在运行过程中如果出现问题，会导致后面的代码无法正常执行，而使用异常机制后，可以对异常进行处理，
 *      同时后续的代码会继续执行，不会中断整个程序。
 *      4. 在异常处理过程中，不要只是简单地输出错误，要尽可能将详细异常进行输出
 *          e.printStackTrace():打印异常的堆栈信息，可以从异常信息的最后一行开始追踪，寻找自己编写的Java类
 *          e.printMessage():返回异常信息描述字符串，是printStackTrace()输出信息的一部分
 *  异常处理的三种方式：
 *      1. 捕获异常
 *          try{代码逻辑}catch(Exception e){异常处理逻辑}
 *          try{代码逻辑}catch(具体的异常Exception e){异常处理逻辑}catch(具体的异常Exception e){异常处理逻辑}
 *              可以针对每一种具体的异常做更丰富处理
 *          注意：当使用多重catch时一定要注意相关异常的程序，将子类放在最前面的catch，父类放在后面的catch
 *          执行过程中，可能存在的情况：
 *          1）正常执行，只执行try中代码
 *          2）遇到异常情况，会处理try中异常代码之前的逻辑，后面不会执行，最后会执行catch
 *          3）使用多重catch的时候，会遇到异常子类不匹配的情况，此时依然会报错，因此建议在catch最后将所有异常的父类写上
 *      2.
 *
 */
public class TestException {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("请输入被除数:");
            int num1 = in.nextInt();
            System.out.print("请输入除数:");
            int num2 = in.nextInt();
            System.out.println(String.format("%d / %d = %d",
                        num1, num2, num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (InputMismatchException e) {
            System.out.println("输入的参数有问题");
        } finally {
            System.out.println("感谢使用本程序！");
        }
    }
}
