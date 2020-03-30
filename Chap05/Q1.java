package Chap05;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int num = scan.nextInt();

        int factorial =0;
        for(int i=0; i<num; i++){
            factorial = num * (num-1);
        }
        System.out.println(factorial);
    }
}
