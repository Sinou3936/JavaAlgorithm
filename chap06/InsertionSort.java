package chap06;

import java.util.Scanner;

public class InsertionSort {
    static void insertionsort(int[] a, int n){
        for(int i=1; i<n; i++){
            int j;
            int temp = a[i];
            for(j=i; j>0 && a[j-1] > temp; j--)
                a[j] = a[j-1];
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        for(int i=0;i<num; i++){
            System.out.print("x["+i+"] :");
            x[i] = scan.nextInt();
        }
        insertionsort(x,num);

        System.out.println("오름 차순 정렬");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"] = "+ x[i]);
        }
    }
}
