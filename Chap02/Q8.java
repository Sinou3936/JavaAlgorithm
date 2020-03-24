package Chap02;

import java.util.Scanner;

public class Q8 {
    static int[][] mdays ={
            {31,28,31,30,31,30,31,31,30,31,30,31},
            {31,29,31,30,31,30,31,31,30,31,30,31}
    };
    static int isLeap(int year){
        return (year %4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1:0;
    }
    static int dayOfYear(int y, int m ,int d){
        System.out.print(d+"일+ ");
        while (--m>0){
            d += mdays[isLeap(y)][m-1];
            System.out.printf("%d(idx: %d)", mdays[isLeap(y)][m-1], m-1);
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int retry;

        System.out.println("그 해 경과 일수 구하시오.");

        do{
            System.out.print("년: "); int year = scan.nextInt();
            System.out.print("월: "); int month = scan.nextInt();
            System.out.print("일: "); int day = scan.nextInt();


            System.out.printf("그해 %d일 째 입니다.\n",dayOfYear(year,month,day));
            System.out.print("한 번 더 할 까요??(1:Y/0:N) : ");
            retry = scan.nextInt();
        }while (retry == 1);
    }
}
