package Chap05;

import java.util.Scanner;

class GCD{
    public int gcd(int x, int y){
        while (y>0){
            int temp = x;
            x= y;
            y = temp%y;
        }
        return  x;
    }

}

public class Q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("두 정수의 최대공약수를 구하시오");

        System.out.print("정수1: "); int num1 = scan.nextInt();
        System.out.print("정수2: "); int num2 = scan.nextInt();
        GCD gcd = new GCD();

        System.out.println("최대 공약수 "+ gcd.gcd(num1, num2));
    }
}
