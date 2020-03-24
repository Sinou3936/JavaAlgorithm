package Chap02;

import java.util.Scanner;

public class CardConvRev {
    static int cardConvRev(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do{
            d[digits++] = dchar.charAt(x%r);
            x /= r;
        }while (x != 0);
            return digits;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int no,cd,dn,retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환");
        do{
            do{
                System.out.print("변환하는 음 아닌 정수: ");
                no = scan.nextInt();
            }while ( no < 0);

            do{
                System.out.print("어떤 진수로 변환할까요?(2~36)? ");
                cd = scan.nextInt();
            }while (cd <2 || cd>36);

            dn = cardConvRev(no,cd,cno);
            System.out.print(cd+ "진수로는 ");
            for(int i= dn -1; i>=0; i--)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.println("한번 더 할 까요? (1:Y/0:N) :");
            retry = scan.nextInt();
        }while (retry == 1);
    }
}
