package Chap05;

import com.sun.deploy.util.SyncAccess;

import java.util.Scanner;

public class Q6 {
    static void move(int no, String x, String y,String z){
        if(no==1){
            System.out.println(no+" :"+ x+ "->"+z);
        }else{
            move(no-1,x,z,y);
            System.out.println(no+" :"+ x+ "->"+z);
            move(no-1,y,x,z);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("하노이탑");
        System.out.print("원반 개수: ");
        int count  = scan.nextInt();

        move(count,"A","B","C");
    }

}
