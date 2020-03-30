package chap06;

import java.util.Scanner;

public class Q10 {
    static void swap(int[]a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void quickSort(int[]a, int left,int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while (a[pl]<x) pl++;
            while (a[pr]>x) pr--;
            if(pl<=pr) swap(a,pl++, pr--);
        }while (pl<=pr);
        if(left<pr) quickSort(a,left,pr);
        if(right>pl) quickSort(a,pl, right);
    }
    static void quickSort(int[]a , int n){
        quickSort(a,0,n-1);
    }

    public static void main(String[] args) {
        int[] x = {5,8,4,6,2,1,3,9,7};

        for(int i=0; i<x.length; i++){
            System.out.println("x["+i+"]: "+x[i]);

        }
        quickSort(x,x.length);

        System.out.println("오름 차순으로 정렬");
        for(int i=0; i<x.length; i++)
            System.out.println("x["+i+"]: "+x[i]);

    }
}
