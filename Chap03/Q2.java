package Chap3;

import java.util.Scanner;

public class Q2 {
    static int seqSearch(int[] a, int n , int key){
        for(int i=0; i<a.length; i++){
            if(a[i] == key)
                return  i;
        }
        return -1;
    }

    static int seqSearchPrint(int[]a, int n, int key){
        System.out.println("    |");
        for(int i=0; i<n; i++){
            System.out.printf("%2d\t",i);
        }
        System.out.println("\n-------------------------\n");
        for(int i=0; i<n; i++){
            System.out.print("  |");
            for(int k=0; k<i; k++){
                System.out.print("  ");
            }
            System.out.printf("*\n%2d|",i);
            for(int j=0; j<n; j++) {
                System.out.printf("%2d", a[j]);
            }
            System.out.println();
            if(a[i] == key)
                return  i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = scan.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = scan.nextInt();
        int idx = seqSearchPrint(x,num,key);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(key+"은 x["+idx+"]에 있습니다.");
    }
}
