package Chap3;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("요소 수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        System.out.println("오름 차순으로 입력하시오.");
        System.out.print("x[0]: ");
        x[0] = scan.nextInt();

        for(int i=1; i<num; i++){
            do{
                System.out.print("x["+i+"]: ");
                x[i] = scan.nextInt();
            }while (x[i]<x[i-1]);
        }

        System.out.print("검색할 값: ");
        int key = scan.nextInt();

        int idx = Arrays.binarySearch(x,key);
        if(idx < 0) {
            System.out.print(key+", x["+idx+"]\t");
            System.out.println("그 값의 요소는 없습니다.");
        }else{
            System.out.println(key+"의 값은 x["+idx+"] 에 있습니다.");
        }
    }
}
