package Chap05;

import java.util.Scanner;

public class Recur {
    static void Recur(int n){
        if(n>0) {
            Recur(n-1);
            System.out.println(n);
            Recur(n-2);
        }
    }

    static void  Recur2(int n){
        if(n>0){
            Recur2(n-2);
            System.out.println(n);
            Recur2(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하시오 ");
        int num = scan.nextInt();

        Recur(num);
        System.out.println();
        Recur2(num);
    }
}
