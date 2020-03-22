package Chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
    static int maxOf(int[] a){
        int max = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("키의 최댓값 구하시오");
        System.out.print("사람의 수: ");
        int member = scan.nextInt();

        int[] heIghts = new int[member];
        for(int i=0; i<member; i++){
            heIghts[i] = 100+random.nextInt(90);
            System.out.println("heights["+i+"] :" + heIghts[i]);
        }
        System.out.println("최댓값: "+maxOf(heIghts));
    }
}
