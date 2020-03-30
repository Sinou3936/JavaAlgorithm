package chap06;

import Chap04.IntStack;
import java.util.Scanner;

public class QuickSort2 {
    static void swap(int[]a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void quickSort(int[]a, int left,int right){
        IntStack lstack = new IntStack(right-left+1);
        IntStack rstack = new IntStack(right-left+1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left+right)/2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr) swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr){
                System.out.println("왼쪽 분할");
                lstack.push(left);
                System.out.print(lstack.push(left)+"\t");
                rstack.push(pr);
                System.out.print(rstack.push(pr)+"\n");
            }
            if (pl <right) {
                System.out.println("오른쪽 분할");
                lstack.push(pl);
                System.out.print(lstack.push(pl)+"\t");
                rstack.push(right);
                System.out.print(rstack.push(right)+"\n");
            }
        }
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
