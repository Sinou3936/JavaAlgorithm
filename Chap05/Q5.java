package Chap05;

import java.util.Scanner;

public class Q5 {
    static void recur3(int n){
        if(n>0){
            recur3(n-1);
            System.out.println(n);
            n = n-2;
        }
    }

    public static void main(String[] args) {
        System.out.print("정수 입력: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        recur3(num);
    }
}
