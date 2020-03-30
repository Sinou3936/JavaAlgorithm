package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = scan.nextInt();
        }

        Arrays.sort(x);

        System.out.println("오름 차순으로 정렬");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"]: "+x[i]);
        }
    }
}
