package Chap05;

import java.util.Scanner;

public class Q7 {
    static void move(int no, int x, int y){
        if(no>1)
            move(no-1,x,6-x-y);
        System.out.println("원반["+no+"]을 "+x+"기둥에서"+y+"기둥으로 옮김");

        no = no-1;
        x = 6-x-y;
        y = y;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("하노이탑");
        System.out.print("원반 개수: ");
        int count  = scan.nextInt();

        move(count,1,3);
    }
}
