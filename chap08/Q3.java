package chap08;

import java.util.Scanner;

public class Q3 {
    static int bmMatch(String txt, String pat){
        int pt ;
        int pp ;
        int txtlen = txt.length();
        int patlen = pat.length();
        int[] skip = new int[Character.MAX_VALUE+1];
        int cnt = 0;
        int k = -1;

        for(pt = 0; pt<=Character.MAX_VALUE; pt++)  skip[pt] = patlen;
        for(pt = 0; pt<patlen -1; pt++) skip[pat.charAt(pt)] = patlen - pt -1;

        while (pt < txtlen){
            pp = patlen -1;
            if(k == pt - pp)
                System.out.print("   ");
            else{
                System.out.printf("%2d   ", pt- pp);
                k = pt - pp;
            }
            for(int i=0; i<txt.length(); i++)
                System.out.print(txt.charAt(i)+" ");
            System.out.println();

            for(int i=0; i<pt*2+4; i++)
                System.out.print(" ");
            System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+':'|');
            System.out.println();
            for(int i=0; i<(pt-pp) *2 +4; i++)
                System.out.print(" ");
            for(int i=0; i<pat.length(); i++)
                System.out.print(pat.charAt(i)+" ");
            System.out.println();

            cnt++;

            while (txt.charAt(pt) == pat.charAt(pp)){
                if(k == pt - pp)
                    System.out.print("   ");
                else{
                    System.out.printf("%2d   ", pt- pp);
                    k = pt - pp;
                }
                for(int i=0; i<txt.length(); i++)
                    System.out.print(txt.charAt(i)+" ");
                System.out.println();

                for(int i=0; i<pt*2+4; i++)
                    System.out.print(" ");
                System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+':'|');
                System.out.println();
                for(int i=0; i<(pt-pp) *2 +4; i++)
                    System.out.print(" ");
                for(int i=0; i<pat.length(); i++)
                    System.out.print(pat.charAt(i)+" ");
                System.out.println();

                cnt++;

                if(pp == 0) return pt;
                pp--;
                pt--;
            }
            pt+= (skip[txt.charAt(pt)] > patlen - pp)? skip[txt.charAt(pt)]: patlen - pp;
        }
        return -1;
    }
    public static void main(String[] args) {
        String s1 = "ABABCDEFGHA";
        String s2 = "ABC";
        System.out.println("텍스트: "+s1);
        System.out.println("패턴: "+s2);

        bmMatch(s1,s2);

    }
}
