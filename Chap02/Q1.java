package Chap02;

import java.util.Random;
import java.util.Scanner;

public class Q1 { static int maxOf(int[] a){
    int max = a[0];
    for(int i=0; i<a.length; i++){
        if(a[i] > max)
            max = a[i];
    }
    return max;
}

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("키 최댓값 구하시오(사람 수는 랜덤)");
        int member = 1+random.nextInt(10);

        int[] heIghts = new int[member];
        for(int i=0; i<member; i++){
            heIghts[i] = 100+random.nextInt(90);
            System.out.println("heights["+i+"] :" + heIghts[i]);
        }
        System.out.println("최댓값: "+maxOf(heIghts));
    }
}
