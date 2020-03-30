package chap06;

import java.util.Scanner;
//분할 과정 추출 하기
public class QuickSort1 {
    static void swap(int[]a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void quickSort(int[]a, int left,int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        System.out.printf("a[%d]~a[%d] : {",left,right);
        for(int i=left; i<right; i++)
            System.out.printf("%d, ",a[i]);
        System.out.printf("%d}\n", a[right]);

        do{
            while (a[pl]<x) pl++;
            while (a[pr]>x) pr--;
            if(pl<=pr) swap(a,pl++, pr--);
        }while (pl<=pr);
        if(left<pr) quickSort(a,left,pr);
        if(right>pl) quickSort(a,pl, right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("배열을 나눕니다.");
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = scan.nextInt();
        }
        quickSort(x,0,num-1);

        System.out.println("오름 차순으로 정렬");
        for(int i=0; i<num; i++)
            System.out.println("x["+i+"]: "+x[i]);

    }
}
