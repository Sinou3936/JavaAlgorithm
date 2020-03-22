package Chap02;

import java.util.Scanner;

public class MaxOfArray {
    static int maxOf(int[] a){
        int max = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i]>max)
                max = a[i];
        }
        return  max;
    }

    public static void main(String[] args) {
        System.out.println("키의 최대값을 구하시오");
        Scanner scan = new Scanner(System.in);
        System.out.print("사람 수: ");
        int member = scan.nextInt();
        int[] height = new int[member];

        for(int i=0; i<height.length; i++){
            System.out.print("height[" +i+ "] :");
            height[i] = scan.nextInt();
        }
        System.out.println("최댓값: "+maxOf(height));
    }
}
