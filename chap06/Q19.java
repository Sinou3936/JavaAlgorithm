package chap06;

import java.util.Scanner;

public class Q19 {
    static void fSort(int[] a, int n ,int min, int max){
        int[]f = new int[max-min+2];
        int[]b  = new int[n];

        for(int i=0; i<n; i++) f[a[i]-min]++;
        for(int i=1; i<=max -min+1; i++) f[i] += f[i-1];
        for(int i=n-1; i>=0; i--) b[--f[a[i]-min]] = a[i];
        for(int i=0; i<n; i++) a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        for(int i=0; i<num; i++){
            do {
                System.out.print("x["+i+"]: ");
                x[i] = scan.nextInt();
            }while (x[i] <0);
        }

        int max= x[0];
        for(int i=1; i<num; i++)
            if(x[i]> max) max = x[i];
        int min = x[0];
        for(int i=1; i<num; i++)
            if(x[i]<min) min = x[i];


        fSort(x,num,min,max);

        System.out.println("오름 차순으로 정렬");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"]: "+x[i]);
        }
    }
}
