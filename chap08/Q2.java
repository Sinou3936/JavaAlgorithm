package chap08;

import java.util.Scanner;

public class Q2 {
    static int kmpMatch(String txt, String pat){
        int pt =1;
        int pp =0;
        int[] skip = new int[pat.length()+1];
        int cnt =0;
        int k = -1;

        skip[pt] = 0;
        while (pt != pat.length()){
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
            if(pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if(pp ==0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }
        pt = pp = 0;
        while (pt!=txt.length() && pp!=pat.length()){
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
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else if(pp == 0) pt++;
            else pp = skip[pp];
        }
        if(pp == pat.length()) return pt - pp;
        return  -1;
    }

    public static void main(String[] args) {
        String s1 = "ABABCDEFGHA";
        System.out.println("텍스트: " +s1);
        String s2 = "ABC";
        System.out.println("패턴: "+s2);
        kmpMatch(s1,s2);

    }
}
