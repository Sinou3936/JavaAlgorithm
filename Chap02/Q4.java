package Chap02;

import java.util.Scanner;

public class Q4 {
    static void copy(int[] a, int[] b){
       for(int i=0; i<b.length; i++){
           if(a.length == b.length)
               a[i] = b[i];
       }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("b의 요소 수: ");
        int nb = scan.nextInt();
        int [] b = new int[nb];

        for(int i=0; i<b.length; i++){
            b[i] = scan.nextInt();
        }
        int [] a = new int [nb];
        copy(a, b);

        for(int i=0; i<a.length; i++){
            System.out.println("a["+i+"]: "+ a[i]);
        }
    }

}
