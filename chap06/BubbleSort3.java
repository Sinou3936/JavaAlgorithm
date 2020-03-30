package chap06;

import java.util.Scanner;

public class BubbleSort3 {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    //버전 3
    static void bubblesort(int[]a, int n){
       int size = a.length;
       int k =0;
       while (k<n-1){
           int last = n-1;
           for(int j=n-1; j>k; j--){
               if(a[j-1] > a[j]){
                   swap(a,j-1, j);
                   last = j;
               }
           }
           k = last;
           for(int i=0; i<size; i++)
               System.out.print(a[i]+" ");
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
