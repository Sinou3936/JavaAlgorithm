package chap06;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    //버전 1
    static void bubblesort(int[]a, int n){
        int size = a.length;
        for(int i=0; i<n-1; i++){
            for(int j=n-1; j>i; j--){
                if(a[j-1] > a[j])
                    swap(a,j-1, j);
            }
            for(int j=0; j<size; j++)
                System.out.print(a[j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("버블정렬(버전1)");
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = scan.nextInt();
        }

        bubblesort(x, num);
        System.out.println("오름 차순 정렬");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"]: "+ x[i]);
        }
    }
}
