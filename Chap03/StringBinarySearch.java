package Chap3;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] x ={
                "abstract", "assert", "boolean", "break", "byte", "case", "catch","char", "class","const","continue",
                "default", "do", "double","else","enum","extends","final","finally","float","for","goto","if","implements",
                "import","instanceof","int","interface","long","native","new","package","private","protected","public",
                "return","short","static","strictfp","super","switch","synchronized","this","throw","throws","transient",
                "try", "void","volatile","while"
        };

        System.out.print("원하는 키워드: ");
        String key = scan.next();

        int idx = Arrays.binarySearch(x,key);

        if(idx<0){
            System.out.println("해당 키워드 없습니다.");
        }else{
            System.out.println("해당 키워드는 x["+idx+"]에 있습니다.");
        }
    }
}
