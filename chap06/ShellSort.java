package chap06;

import java.util.Scanner;

public class ShellSort {
    static void shellsort(int[] a ,int n){
        int size = a.length;
        int cnt = 0;
        for(int h = n/2; h>0; h/=2){
            for(int i=h; i<n; i++){
                int j;
                int temp = a[i];
                for(j=i-h; j>=0 && a[j]>temp; j-=h) {
                    a[j + h] = a[j];
                    cnt++;
                }
                a[j+h] = temp;
                for(int k=0; k<size; k++){
                    System.out.print(a[k]+ " ");
                }
                System.out.println();

            }
        }
        System.out.println("이동 횟수: "+cnt);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("셀정렬(버전1)");
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        for(int i=0;i<num; i++){
            System.out.print("x["+i+"] :");
            x[i] = scan.nextInt();
        }
        shellsort(x,num);

       /* System.out.println("오름 차순 정렬");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"] = "+ x[i]);
        }*/
    }
}
