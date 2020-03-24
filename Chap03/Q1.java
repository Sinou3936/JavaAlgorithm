package Chap3;

import java.util.Scanner;

public class Q1 {
    static int seqSearchSen(int[] a, int n , int key){
        a[n] = key;

        for(int i=0; i<a.length; i++){
            if(a[i] == key)
                return  i;

        }
        return  -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[] x = new int[num+1];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = scan.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = scan.nextInt();
        int idx = seqSearchSen(x,num,key); //배열의 x 값의 key 값 요소 검색

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(key+"은 x["+idx+"]에 있습니다.");
    }
}
