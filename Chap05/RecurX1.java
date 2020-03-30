package Chap05;

import Chap04.IntStack;

import java.util.Scanner;

public class RecurX1 {
    static void recur(int n){
        while (n>0){
            recur(n-1);
            System.out.println(n);
            n = n-2;
        }
    }
    static void recur2(int n){
        IntStack s = new IntStack(n);
        while (true){
            if(n>0){
                s.push(n);
                n = n-1;
                continue;
            }
            if(s.isEmpty() != true){
                n = s.pop();
                System.out.println(n);
                n= n-2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정수: ");
        int num =scan.nextInt();

        recur(num);
        System.out.println();
        recur2(num);
    }
}
