package Chap02;

import java.util.Scanner;

public class Q5 {

    static void rcopy(int[]a, int[]b){
        for(int i=0; i<b.length; i++){
            int max = b.length-i-1;
            int temp = a[i];
            a[i] = b[max];
            b[max] = temp;
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
        rcopy(a, b);

        for(int i=0; i<a.length; i++){
            System.out.println("a["+i+"]: "+a[i]);
        }
    }
}
