package Chap05;

import java.util.Scanner;

public class EuclidGCD {

    static  int gcd(int x, int y){
        if(y == 0)
            return  x;
        else
            return  gcd(y,x%y);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("두 정수의 최대 공약수를 구하시오");

        System.out.print("정수1: "); int num1 = scan.nextInt();
        System.out.print("정수2: "); int num2 = scan.nextInt();

        System.out.println("최대 공약수는 : "+gcd(num1,num2)+ "입니다.");
    }
}
