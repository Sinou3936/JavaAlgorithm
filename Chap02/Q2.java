package Chap02;

import java.util.Scanner;

public class Q2 {
    static void swap(int[] a, int idx1, int idx2){
        int t = 0;
        t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void reverse(int[] a){
        print(a);
        for(int i=0; i<a.length /2; i++) {
            int max = a.length-i-1;
            System.out.println("a[" + i +"]와 a["+max +"]를 교환");
            swap(a, i,max);
            print(a);
        }
    }
    static void print(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();

    }
    public static void main(String[] args){
        int [] x = {5,10,73,2,-5,42} ;
        reverse(x);

        System.out.println("요소를 역순을 정렬");
    }
}
