package Chap05;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n ){
        if(n>0)
            return n* factorial(n-1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하시오: ");
        int num = scan.nextInt();

        System.out.println(num+" 의 팩토리얼은 "+ factorial(num) + "입니다");
    }
}
