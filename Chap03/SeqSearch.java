package Chap3;

import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a, int n , int key){
        /*int i=0;
        while (true){
            if(i==n)
                return  -1; //검색 실패 시 -1
            else if(a[i] == key)
                return  i; // 검색 성공 시 (인덱스 반환)

            i++;
        }*/
        for(int i=0; i<a.length; i++){
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
        int idx = seqSearch(x,num,key);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(key+"은 x["+idx+"]에 있습니다.");
    }
}
